package ir.verjik.gateway;

import ir.verjik.dto.PaymentRequestDTO;
import ir.verjik.dto.PaymentResponseDTO;

/*
* طراحی مناسب برای
* strategy pattern
* */
public interface PaymentGateway {
    PaymentResponseDTO pay(PaymentRequestDTO request);
    String getGatewayName();
}
