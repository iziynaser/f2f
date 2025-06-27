package com.f2f.service;

import com.f2f.dto.OrderDTO;
import com.f2f.dto.OrderStatusDTO;
import com.f2f.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    public Order createOrder(OrderDTO orderDTO) ;
    public void updateOrderStatus(Long orderId, OrderStatusDTO statusDTO);
    public Optional<OrderDTO> getOrderById(Long id) ;
    public OrderDTO updateOrder(Long orderId, OrderDTO orderDTO) ;
    public void deleteOrder(Long id);
    List<OrderDTO> getAllOrders();
}
