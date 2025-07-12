package com.f2f.repository;

import com.f2f.entity.PaymentRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRequestRepository  extends JpaRepository<PaymentRequest, Long> {
    Optional<PaymentRequest> findByAuthorityCode(String authorityCode);

}
