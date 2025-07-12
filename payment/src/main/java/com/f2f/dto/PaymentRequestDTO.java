package com.f2f.dto;

import com.f2f.entity.PaymentType;
import com.f2f.enums.PaymentGatewayType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequestDTO {
    private Long orderId;
    private Long amount;
    private String currency;
    private PaymentType paymentType;
    private PaymentGatewayType gatewayType;
    // داده‌های پرداخت (مثلاً کارت، اطلاعات درگاه) در صورت نیاز
}

