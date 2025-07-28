package com.f2f.service;


import com.f2f.dto.PaymentInitRequestDTO;
import com.f2f.dto.PaymentInitResponseDTO;
import com.f2f.dto.PaymentVerifyRequestDTO;
import com.f2f.dto.PaymentVerifyResponseDTO;
import com.f2f.entity.PaymentRequest;
import com.f2f.enums.PaymentGatewayType;
import com.f2f.enums.PaymentStatus;
import com.f2f.port.PaymentGatewayPort;
import com.f2f.repository.PaymentRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRequestRepository repository;
    private final Map<PaymentGatewayType, PaymentGatewayPort> gatewayMap;
    private final PaymentTransactionService transactionService;

    private static final int AUTHORITY_EXPIRATION_MINUTES = 30;

    /**
     * شروع پرداخت (initiate)
     * @param dto داده‌های درخواست پرداخت
     * @param userId شناسه کاربر درخواست‌کننده
     * @return پاسخ شروع پرداخت شامل redirectUrl و authority
     */
    @Transactional
    public PaymentInitResponseDTO initiatePayment(PaymentInitRequestDTO dto, Long userId) {
        String securityToken = UUID.randomUUID().toString();

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

    /**
     * تایید پرداخت (verify)
     * @param dto داده‌های درخواست تایید (authority و callbackUrl)
     * @param userId شناسه کاربر تاییدکننده
     * @return نتیجه تایید پرداخت
     */
    @Transactional
    public PaymentVerifyResponseDTO verifyPayment(PaymentVerifyRequestDTO dto, Long userId) {
        PaymentRequest req = repository.findByAuthorityCode(dto.getAuthority())
                .filter(r -> r.getStatus() == PaymentStatus.INITIATED || r.getStatus() == PaymentStatus.CREATED)
                .filter(r -> r.getRequestTime().isAfter(LocalDateTime.now().minusMinutes(AUTHORITY_EXPIRATION_MINUTES)))
                .orElseThrow(() -> new RuntimeException("Invalid or expired authority code"));

        if (!req.getUserId().equals(userId)) {
            throw new SecurityException("User does not own this payment request");
        }

        String callbackToken = extractTokenFromUrl(dto.getCallbackUrl());
        if (!req.getSecurityToken().equals(callbackToken)) {
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

    // متدهای کمکی:

    private String appendTokenToCallbackUrl(String callbackUrl, String token) {
        if (callbackUrl.contains("?")) {
            return callbackUrl + "&token=" + token;
        } else {
            return callbackUrl + "?token=" + token;
        }
    }

    private String extractTokenFromUrl(String callbackUrl) {
        try {
            String[] parts = callbackUrl.split("\\?");
            if (parts.length < 2) return null;
            String[] params = parts[1].split("&");
            for (String param : params) {
                String[] keyValue = param.split("=");
                if (keyValue.length == 2 && keyValue[0].equals("token")) {
                    return keyValue[1];
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to extract token from callback URL", e);
        }
        return null;
    }
}
