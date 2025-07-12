package com.f2f.port;

import com.f2f.dto.PaymentRequestDTO;
import com.f2f.dto.PaymentResponseDTO;

public interface PaymentPort {
    PaymentResponseDTO processPayment(PaymentRequestDTO request);
}
