package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.enums.PaymentGatewayType;
import com.f2f.enums.PaymentStatus;
import com.f2f.enums.PaymentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "PAYMENT_TRANSACTION")
@Getter
@Setter
public class PaymentTransaction extends BaseEntity {

    @Column(nullable = false)
    private Long orderId;

    @Column(nullable = false)
    private Long amount;

    @Column(length = 3, nullable = false)
    private String currency;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentType paymentType; // حضوری، اینترنتی و ...

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentGatewayType gatewayType; // مثلا ZARINPAL, PAYPAL, CASH

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status; // CREATED, SUCCESS, FAILED, PENDING

    @Column(name = "SETTLED")
    private boolean settled; // true if money settled to merchant

    @Column(name = "SETTLEMENT_DATE")
    private LocalDateTime settlementDate;

    @Column(name = "REFUNDED")
    private boolean refunded;

    @Column(name = "REFUND_REASON")
    private String refundReason;

    private String transactionId; // شناسه تراکنش در درگاه

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
