package ir.verjik.dto;

import ir.verjik.gateway.PaymentGateway;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentVerifyRequestDTO {
    private String authority;
    private PaymentGateway gateway;
    private String callbackUrl;
    private String token;
}
