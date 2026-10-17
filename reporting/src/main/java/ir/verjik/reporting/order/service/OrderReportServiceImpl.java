package ir.verjik.reporting.order.service;

import ir.verjik.dto.OrderDTO;
import ir.verjik.mapper.OrderMapper;
import ir.verjik.reporting.order.dto.CustomerOrderCountReportDTO;
import ir.verjik.repository.OrderRepository;
import ir.verjik.repository.OrderStatusRepository;
import ir.verjik.repository.PersonRepository;
import ir.verjik.service.OrderService;
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
