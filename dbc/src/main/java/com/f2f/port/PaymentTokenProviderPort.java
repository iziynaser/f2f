package com.f2f.port;

public interface PaymentTokenProviderPort {
    String generatePaymentToken(Long userId);
}
