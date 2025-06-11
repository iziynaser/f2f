package com.f2f.repository;

import com.f2f.entity.order.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {

    List<OrderStatus> findByOrderIdOrderByStatusDateDesc(Long orderId);

}
