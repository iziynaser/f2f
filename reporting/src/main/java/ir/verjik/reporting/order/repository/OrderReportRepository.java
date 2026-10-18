package ir.verjik.reporting.order.repository;

import ir.verjik.entity.Order;
import ir.verjik.reporting.order.dto.CustomerOrderCountReportDTO;
import ir.verjik.reporting.order.dto.CustomerOrderReportReportDTO;
import ir.verjik.reporting.order.dto.OrderStatusSummaryReportDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderReportRepository extends JpaRepository<Order, Long> {

    @Query("SELECT new ir.verjik.dto.CustomerOrderCountDTO(o.customer.id, CONCAT(o.customer.firstName, ' ', o.customer.lastName), COUNT(o)) " +
            "FROM Order o GROUP BY o.customer.id, o.customer.firstName, o.customer.lastName")
    List<CustomerOrderCountReportDTO> countOrdersByCustomer();

    @Query("SELECT new ir.verjik.dto.CustomerOrderReportDTO(o.id, o.orderCode, o.orderDate, o.currentStatus, " +
            "COALESCE(SUM(oi.totalPrice), 0), COUNT(oi)) " +
            "FROM Order o LEFT JOIN o.orderItems oi " +
            "WHERE o.customer.id = :customerId " +
            "GROUP BY o.id, o.orderCode, o.orderDate, o.currentStatus")
    public List<CustomerOrderReportReportDTO> getCustomerOrders(@Param("customerId") Long customerId);


    @Query("""
        SELECT new ir.verjik.dto.OrderStatusSummaryDTO(o.currentStatus, COUNT(o))
        FROM Order o
        GROUP BY o.currentStatus
    """)
    public List<OrderStatusSummaryReportDTO> countOrdersByStatus();

    public List<Order> findByCustomerId(Long customerId);

}