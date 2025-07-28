package com.f2f.repository;

import com.f2f.entity.PaymentGatewayConfig;
import com.f2f.enums.PaymentGatewayType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentGatewayConfigRepository extends JpaRepository<PaymentGatewayConfig, PaymentGatewayType> {
    List<PaymentGatewayConfig> findByActiveTrue();
    Optional<PaymentGatewayConfig> findByDefaultGatewayTrue();
}
