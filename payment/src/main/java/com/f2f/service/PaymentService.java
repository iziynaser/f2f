package com.f2f.service;


import com.f2f.dto.PaymentInitRequestDTO;
import com.f2f.dto.PaymentInitResponseDTO;
import com.f2f.dto.PaymentVerifyRequestDTO;
import com.f2f.dto.PaymentVerifyResponseDTO;
import com.f2f.entity.PaymentRequest;
import com.f2f.enums.PaymentGatewayType;
import com.f2f.enums.PaymentStatus;
import com.f2f.port.PaymentGatewayPort;
import com.f2f.port.PaymentTokenProviderPort;
import com.f2f.repository.PaymentRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRequestRepository repository;
    private final Map<PaymentGatewayType, PaymentGatewayPort> gatewayMap;
    private final PaymentTransactionService transactionService;
    private final PaymentTokenProviderPort tokenProvider;

    private static final int AUTHORITY_EXPIRATION_MINUTES = 30;

    @Transactional
    public PaymentInitResponseDTO initiatePayment(PaymentInitRequestDTO dto, Long userId) {
        String securityToken = tokenProvider.generatePaymentToken(userId);

        PaymentRequest req = new PaymentRequest();
        req.setAmount(dto.getAmount());
        req.setOrderId(dto.getOrderId());
        req.setGateway(dto.getGateway());
        req.setStatus(PaymentStatus.INITIATED);
        req.setRequestTime(LocalDateTime.now());
        req.setSecurityToken(securityToken);
        req.setUserId(userId);

        String secureCallbackUrl = appendTokenToCallbackUrl(dto.getCallbackUrl(), securityToken);
        req.setCallbackUrl(secureCallbackUrl);

        repository.save(req);

        PaymentInitResponseDTO response = gatewayMap.get(dto.getGateway()).initiate(req);

        req.setAuthorityCode(response.getAuthority());
        repository.save(req);

        return response;
    }

    @Transactional
    public PaymentVerifyResponseDTO verifyPayment(PaymentVerifyRequestDTO dto, Long userId) {
        PaymentRequest req = repository.findByAuthorityCode(dto.getAuthority())
                .filter(r -> r.getStatus() == PaymentStatus.INITIATED || r.getStatus() == PaymentStatus.CREATED)
                .filter(r -> r.getRequestTime().isAfter(LocalDateTime.now().minusMinutes(AUTHORITY_EXPIRATION_MINUTES)))
                .orElseThrow(() -> new RuntimeException("Invalid or expired authority code"));

        if (!req.getUserId().equals(userId)) {
            throw new SecurityException("User does not own this payment request");
        }

        if (!req.getSecurityToken().equals(dto.getToken())) {
            throw new SecurityException("Invalid callback token – possible forgery.");
        }

        PaymentVerifyResponseDTO result = gatewayMap.get(req.getGateway())
                .verify(dto.getAuthority(), req.getAmount());

        req.setStatus(result.isSuccess() ? PaymentStatus.SUCCESS : PaymentStatus.FAILED);
        req.setTrackingCode(result.getTrackingCode());
        req.setPaymentTime(LocalDateTime.now());
        repository.save(req);

        transactionService.createTransaction(req, result);

        return result;
    }

    private String appendTokenToCallbackUrl(String callbackUrl, String token) {
        try {
            URI uri = new URI(callbackUrl);
            String query = uri.getQuery();
            String newQuery = (query == null || query.isEmpty())
                    ? "token=" + token
                    : query + "&token=" + token;

            URI newUri = new URI(
                    uri.getScheme(), uri.getAuthority(), uri.getPath(), newQuery, uri.getFragment()
            );
            return newUri.toString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to append token to callback URL", e);
        }
    }

}
