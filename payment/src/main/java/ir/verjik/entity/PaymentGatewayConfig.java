package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;
import ir.verjik.enums.PaymentGatewayType;
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
