package com.f2f.repository;

import com.f2f.entity.PaymentRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRequestRepository  extends JpaRepository<PaymentRequest, Long> {
}
