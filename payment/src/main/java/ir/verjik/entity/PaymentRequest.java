package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import ir.verjik.enums.PaymentGatewayType;
import ir.verjik.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "PAYMENT_REQUEST")
public class PaymentRequest extends BaseEntity implements Serializable {

    @Column(name="user_acc_id")
    private Long userId;

    @Column(name = "order_id")
    private Long orderId; // یا referenceId از سیستم سفارش

    @Enumerated(EnumType.STRING)
    private PaymentGatewayType gateway;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private Long amount;

    private String authorityCode; // مثل Authority در زرین‌پال

    private String trackingCode;  // شماره تراکنش نهایی

    private String callbackUrl;

    @Column(name = "request_time")
    private LocalDateTime requestTime;

    @Column(name = "payment_time")
    private LocalDateTime paymentTime;

    @Column(name = "SECURITY_TOKEN")
    private String securityToken;

}
