package com.f2f.service;

import com.f2f.dto.OrderStatusDTO;

import java.util.List;
import java.util.stream.DoubleStream;


public interface OrderStatusService {

    OrderStatusDTO createStatus(OrderStatusDTO orderStatusDTO);

    List<OrderStatusDTO> getStatusesByOrderId(Long orderId);

    OrderStatusDTO updateStatus(Long id, OrderStatusDTO orderStatusDTO);

    void deleteStatus(Long id);
}