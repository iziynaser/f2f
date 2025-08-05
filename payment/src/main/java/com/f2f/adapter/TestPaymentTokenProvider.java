package com.f2f.adapter;

import com.f2f.port.PaymentTokenProviderPort;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TestPaymentTokenProvider implements PaymentTokenProviderPort {

    @Override
    public String generatePaymentToken(Long userId) {
        // مقدار تستی – بعداً اینجا به auth وصل می‌شود
        return "TEST-" + UUID.randomUUID();
    }
}
