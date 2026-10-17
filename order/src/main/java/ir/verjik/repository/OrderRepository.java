package ir.verjik.repository;

import ir.verjik.entity.Order;
import ir.verjik.enums.OrderStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerIdAndCurrentStatus(Long customerId, OrderStatusEnum status);
    List<Order> findByCustomerId(Long customerId);
    Optional<Order> findByOrderCode(String orderCode);
}
