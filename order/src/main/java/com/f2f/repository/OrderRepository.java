package com.f2f.repository;

import com.f2f.entity.Order;
import com.f2f.enums.OrderStatusEnum;
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
