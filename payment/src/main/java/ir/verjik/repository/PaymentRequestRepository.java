package ir.verjik.repository;

import ir.verjik.entity.PaymentRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRequestRepository  extends JpaRepository<PaymentRequest, Long> {
    Optional<PaymentRequest> findByAuthorityCode(String authorityCode);

}
