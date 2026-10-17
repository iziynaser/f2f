package ir.verjik.repository;

import ir.verjik.entity.PaymentGatewayConfig;
import ir.verjik.enums.PaymentGatewayType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentGatewayConfigRepository extends JpaRepository<PaymentGatewayConfig, PaymentGatewayType> {
    List<PaymentGatewayConfig> findByActiveTrue();
    Optional<PaymentGatewayConfig> findByDefaultGatewayTrue();
}
