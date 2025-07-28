package com.f2f.dto;

import com.f2f.gateway.PaymentGateway;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentVerifyRequestDTO {
    private String authority;
    private PaymentGateway gateway;
    private String callbackUrl;
}
