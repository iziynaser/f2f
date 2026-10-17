package ir.verjik.service;

import ir.verjik.dto.OrderDTO;
import ir.verjik.dto.OrderItemDTO;
import ir.verjik.dto.OrderStatusDTO;
import ir.verjik.enums.OrderStatusEnum;

import java.util.List;
import java.util.Optional;

/*
 فقط برای مدیریت سفارش های ثبت شده استفاده می شود
 */
public interface OrderService {

    OrderDTO createOrder(OrderDTO orderDTO);

    void updateOrderStatus(Long orderId, OrderStatusDTO statusDTO);

    Optional<OrderDTO> getOrderById(Long id);

    OrderDTO updateOrder(Long orderId, OrderDTO orderDTO);

    void deleteOrder(Long id);

    List<OrderDTO> getAllOrders();

    List<OrderDTO> getOrdersByCustomerAndStatus(Long customerId, OrderStatusEnum status);

    List<OrderItemDTO> getOrderItemsByOrderCode(String orderCode);

}
