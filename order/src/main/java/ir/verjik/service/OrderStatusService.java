package ir.verjik.service;

import ir.verjik.dto.OrderStatusDTO;

import java.util.List;


public interface OrderStatusService {

    OrderStatusDTO createStatus(OrderStatusDTO orderStatusDTO);

    List<OrderStatusDTO> getStatusesByOrderId(Long orderId);

    OrderStatusDTO updateStatus(Long id, OrderStatusDTO orderStatusDTO);

    void deleteStatus(Long id);
}