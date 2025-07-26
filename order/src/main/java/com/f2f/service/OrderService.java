package com.f2f.service;

import com.f2f.dto.OrderDTO;
import com.f2f.dto.OrderItemDTO;
import com.f2f.dto.OrderStatusDTO;
import com.f2f.entity.Order;
import com.f2f.enums.OrderStatusEnum;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
