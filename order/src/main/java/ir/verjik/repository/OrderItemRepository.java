package ir.verjik.repository;

import ir.verjik.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findByOrderId(Long orderId);

    @Query("SELECT oi FROM OrderItem oi JOIN FETCH oi.order o WHERE o.id = :orderId")
    List<OrderItem> findByOrderIdWithOrder(@Param("orderId") Long orderId);

    @Query("SELECT SUM(oi.totalPrice) FROM OrderItem oi WHERE oi.order.id = :orderId")
    Long getTotalAmountForOrder(@Param("orderId") Long orderId);
}
