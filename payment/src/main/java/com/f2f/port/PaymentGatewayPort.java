package com.f2f.port;

import com.f2f.dto.PaymentInitResponseDTO;
import com.f2f.dto.PaymentVerifyResponseDTO;
import com.f2f.entity.PaymentRequest;

public interface PaymentGatewayPort {
    PaymentInitResponseDTO initiate(PaymentRequest request);
    PaymentVerifyResponseDTO verify(String authority, Long amount);
    public String getGatewayName();
}
