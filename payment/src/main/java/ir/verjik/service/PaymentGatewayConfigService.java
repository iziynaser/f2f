package ir.verjik.service;

import ir.verjik.entity.PaymentGatewayConfig;
import ir.verjik.enums.PaymentGatewayType;
import ir.verjik.repository.PaymentGatewayConfigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentGatewayConfigService {

    private final PaymentGatewayConfigRepository configRepository;

    public List<PaymentGatewayConfig> getActiveGateways() {
        return configRepository.findByActiveTrue();
    }

    public PaymentGatewayConfig getConfig(PaymentGatewayType type) {
        return configRepository.findById(type)
                .orElseThrow(() -> new RuntimeException("Gateway config not found"));
    }

    public PaymentGatewayType getDefaultGatewayType() {
        return configRepository.findByDefaultGatewayTrue()
                .map(PaymentGatewayConfig::getGatewayType)
                .orElseThrow(() -> new RuntimeException("Default gateway not configured"));
    }

    public void setDefaultGateway(PaymentGatewayType type) {
        configRepository.findAll().forEach(config -> {
            config.setDefaultGateway(config.getGatewayType() == type);
        });
        configRepository.flush();
    }

    public void activateGateway(PaymentGatewayType type, boolean active) {
        PaymentGatewayConfig config = getConfig(type);
        config.setActive(active);
        configRepository.save(config);
    }
}
