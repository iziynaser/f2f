package com.f2f.service;

import com.f2f.dto.*;
import com.f2f.entity.PaymentRequest;
import com.f2f.enums.PaymentStatus;
import com.f2f.gateway.PaymentGateway;
import com.f2f.port.PaymentGatewayPort;
import com.f2f.repository.PaymentRequestRepository;
import com.f2f.repository.PaymentTransactionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRequestRepository repository;
    private final Map<PaymentGateway, PaymentGatewayPort> gatewayMap;

    public PaymentInitResponseDTO initiatePayment(PaymentInitRequestDTO dto) {
        PaymentRequest req = new PaymentRequest();
        req.setAmount(dto.getAmount());
        req.setOrderId(dto.getOrderId());
        req.setGateway(dto.getGateway());
        req.setCallbackUrl(dto.getCallbackUrl());
        req.setStatus(PaymentStatus.INITIATED);
        req.setRequestTime(LocalDateTime.now());

        repository.save(req);
        return gatewayMap.get(dto.getGateway()).initiate(req);
    }

    public PaymentVerifyResponseDTO verifyPayment(PaymentVerifyRequestDTO dto) {
        PaymentRequest req = repository.findByAuthorityCode(dto.getAuthority())
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        PaymentVerifyResponseDTO result = gatewayMap.get(dto.getGateway())
                .verify(dto.getAuthority(), req.getAmount());

        req.setStatus(result.isSuccess() ? PaymentStatus.SUCCESS : PaymentStatus.FAILED);
        req.setTrackingCode(result.getTrackingCode());
        req.setPaymentTime(LocalDateTime.now());

        repository.save(req);
        return result;
    }
}
