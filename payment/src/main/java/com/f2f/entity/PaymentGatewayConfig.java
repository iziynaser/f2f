package com.f2f.entity;

import com.f2f.enums.PaymentGatewayType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PAYMENT_GATEWAY_CONFIG")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentGatewayConfig {

    @Id
    @Enumerated(EnumType.STRING)
    private PaymentGatewayType gatewayType;

    private boolean active;

    private boolean defaultGateway; // فقط یکی می‌تواند true باشد

    private String merchantId;

    private String callbackUrl;

    private boolean sandbox;

    private String description;
}
