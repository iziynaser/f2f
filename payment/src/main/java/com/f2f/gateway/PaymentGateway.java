package com.f2f.gateway;

import com.f2f.dto.PaymentRequestDTO;
import com.f2f.dto.PaymentResponseDTO;

public interface PaymentGateway {
    PaymentResponseDTO pay(PaymentRequestDTO request);
    String getGatewayName();
}
