package com.f2f.reporting.order.service;

import com.f2f.dto.OrderDTO;
import com.f2f.mapper.OrderMapper;
import com.f2f.reporting.order.dto.CustomerOrderCountReportDTO;
import com.f2f.repository.OrderRepository;
import com.f2f.repository.OrderStatusRepository;
import com.f2f.repository.PersonRepository;
import com.f2f.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public abstract class OrderReportServiceImpl implements OrderService {

    OrderMapper orderMapper;

    @Autowired
    private OrderRepository orderRepository;

    public List<CustomerOrderCountReportDTO> getCustomerOrderCounts() {
        return null;
    }

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<OrderDTO> getOrderById(Long id) {

        return orderRepository.findById(id).map(orderMapper::toDto);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return List.of();
    }

}
