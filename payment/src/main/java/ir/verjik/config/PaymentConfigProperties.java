package ir.verjik.config;

import ir.verjik.enums.PaymentGatewayType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "payment")
@Getter
@Setter
public class PaymentConfigProperties {
    private PaymentGatewayType defaultGateway;
}
