package ir.verjik.dto;

import ir.verjik.enums.PaymentGatewayType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentInitRequestDTO {
    private Long orderId;
    private Long amount;
    private PaymentGatewayType gateway;
    private String callbackUrl;
}