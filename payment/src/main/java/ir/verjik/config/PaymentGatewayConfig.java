package ir.verjik.config;

import ir.verjik.enums.PaymentGatewayType;
import ir.verjik.port.PaymentGatewayPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class PaymentGatewayConfig {

    @Bean
    public Map<PaymentGatewayType, PaymentGatewayPort> paymentGatewayPorts(List<PaymentGatewayPort> ports) {
        return ports.stream().collect(Collectors.toMap(
                p -> PaymentGatewayType.valueOf(p.getGatewayName()), Function.identity()
        ));
    }

}
