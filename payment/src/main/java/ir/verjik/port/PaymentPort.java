package ir.verjik.port;

import ir.verjik.dto.PaymentRequestDTO;
import ir.verjik.dto.PaymentResponseDTO;

public interface PaymentPort {
    PaymentResponseDTO processPayment(PaymentRequestDTO request);
}
