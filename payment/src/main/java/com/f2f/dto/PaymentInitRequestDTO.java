package com.f2f.dto;

import com.f2f.enums.PaymentGatewayType;
import com.f2f.gateway.PaymentGateway;
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