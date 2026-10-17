package ir.verjik.port;

import ir.verjik.dto.PaymentInitResponseDTO;
import ir.verjik.dto.PaymentVerifyResponseDTO;
import ir.verjik.entity.PaymentRequest;

public interface PaymentGatewayPort {
    PaymentInitResponseDTO initiate(PaymentRequest request);
    PaymentVerifyResponseDTO verify(String authority, Long amount);
    public String getGatewayName();
}
