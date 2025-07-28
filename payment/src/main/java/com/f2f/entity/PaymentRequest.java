package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.enums.PaymentGatewayType;
import com.f2f.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "PAYMENT_REQUEST")
public class PaymentRequest extends BaseEntity {

    private Long userId;

    private Long orderId; // یا referenceId از سیستم سفارش

    @Enumerated(EnumType.STRING)
    private PaymentGatewayType gateway;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private Long amount;

    private String authorityCode; // مثل Authority در زرین‌پال

    private String trackingCode;  // شماره تراکنش نهایی

    private String callbackUrl;

    private LocalDateTime requestTime;
    private LocalDateTime paymentTime;

    @Column(name = "SECURITY_TOKEN")
    private String securityToken;

}
