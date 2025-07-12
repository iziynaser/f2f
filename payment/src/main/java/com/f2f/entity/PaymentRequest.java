package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.enums.PaymentStatus;
import com.f2f.gateway.PaymentGateway;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "PAYMENT_REQUEST")
public class PaymentRequest extends BaseEntity {

    private Long orderId; // یا referenceId از سیستم سفارش

    @Enumerated(EnumType.STRING)
    private PaymentGateway gateway;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private Long amount;

    private String authorityCode; // مثل Authority در زرین‌پال

    private String trackingCode;  // شماره تراکنش نهایی

    private String callbackUrl;

    private LocalDateTime requestTime;
    private LocalDateTime paymentTime;
}
