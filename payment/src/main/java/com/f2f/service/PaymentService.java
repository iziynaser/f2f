package com.f2f.service;

import com.f2f.dto.*;
import com.f2f.entity.PaymentRequest;
import com.f2f.entity.PaymentTransaction;
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
    private final PaymentTransactionService transactionService;

    @Transactional
    public PaymentInitResponseDTO initiatePayment(PaymentInitRequestDTO dto) {
        // ایجاد PaymentRequest
        PaymentRequest req = new PaymentRequest();
        req.setAmount(dto.getAmount());
        req.setOrderId(dto.getOrderId());
        req.setGateway(dto.getGateway());
        req.setCallbackUrl(dto.getCallbackUrl());
        req.setStatus(PaymentStatus.INITIATED);
        req.setRequestTime(LocalDateTime.now());

        repository.save(req);

        // فراخوانی درگاه پرداخت و گرفتن Authority + Redirect URL
        PaymentInitResponseDTO response = gatewayMap.get(dto.getGateway()).initiate(req);

        // ذخیره authorityCode دریافتی از درگاه در PaymentRequest
        req.setAuthorityCode(response.getAuthority());
        repository.save(req);

        return response;
    }

    @Transactional
    public PaymentVerifyResponseDTO verifyPayment(PaymentVerifyRequestDTO dto) {
        // یافتن PaymentRequest بر اساس authorityCode
        PaymentRequest req = repository.findByAuthorityCode(dto.getAuthority())
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        // فراخوانی verify از درگاه مربوطه
        PaymentVerifyResponseDTO result = gatewayMap.get(dto.getGateway())
                .verify(dto.getAuthority(), req.getAmount());

        // بروزرسانی وضعیت PaymentRequest
        req.setStatus(result.isSuccess() ? PaymentStatus.SUCCESS : PaymentStatus.FAILED);
        req.setTrackingCode(result.getTrackingCode());
        req.setPaymentTime(LocalDateTime.now());
        repository.save(req);

        // ایجاد PaymentTransaction جدید
        PaymentTransaction tx = transactionService.createTransaction(req, result);

        // ممکن است بخواهی در نتیجه نیز اطلاعات تراکنش را برگردانی (اختیاری)
        return result;
    }
}
