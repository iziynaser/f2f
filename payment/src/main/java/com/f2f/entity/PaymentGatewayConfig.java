package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.enums.PaymentGatewayType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "PAYMENT_GATEWAY_CONFIG")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentGatewayConfig extends BaseEntity implements Serializable {

    @Enumerated(EnumType.STRING)
    private PaymentGatewayType gatewayType;

    private boolean active;

    private boolean defaultGateway;

    private String merchantId;

    private String callbackUrl;

    private boolean sandbox;

    private String description;
}
