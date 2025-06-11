package com.f2f.service;

import com.f2f.dao.OrderRepository;
import com.f2f.dao.ProductItemRepository;
import com.f2f.dao.person.PersonRepository;
import com.f2f.entity.PersonEntity;
import com.f2f.dto.OrderDTO;
import com.f2f.dto.OrderItemDTO;
import com.f2f.dto.OrderStatusDTO;
import com.f2f.entity.order.Order;
import com.f2f.entity.order.OrderItem;
import com.f2f.entity.order.OrderStatus;
import com.f2f.entity.product.ProductItem;
import com.f2f.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    OrderMapper orderMapper;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductItemRepository productItemRepository;

    @Autowired
    private com.f2f.repository.OrderStatusRepository orderStatusRepository;

    @Autowired
    private PersonRepository personRepository;

    // ثبت سفارش جدید
    @Transactional
    public Order createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        //order.setCustomerId(orderDTO.getCustomerId());

        Long customerId = orderDTO.getCustomerId();
        if (customerId != null) {
            PersonEntity customer = personRepository.findById(customerId)
                    .orElseThrow(() -> new RuntimeException("Person not found with id: " + customerId));
            order.setCustomer(customer);
        }

        order.setOrderDate(LocalDateTime.now());

        Set<OrderItem> orderItems = new HashSet<>();
        for (OrderItemDTO itemDTO : orderDTO.getItems()) {
            ProductItem productItem = productItemRepository.findById(itemDTO.getProductItemId())
                    .orElseThrow(() -> new RuntimeException("ProductItem not found"));

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProductItem(productItem);
            orderItem.setQuantity(itemDTO.getQuantity());
            orderItem.setUnitPrice(productItem.getDefaultPrice());
            orderItem.setTotalPrice(productItem.getDefaultPrice() * itemDTO.getQuantity());

            orderItems.add(orderItem);
        }

        order.setOrderItems(orderItems);
        order.setCurrentStatus("CREATED");

        order = orderRepository.save(order);

        // وضعیت اولیه سفارش
        OrderStatus initialStatus = new OrderStatus();
        initialStatus.setOrder(order);
        initialStatus.setStatus("CREATED");
        initialStatus.setStatusDate(LocalDateTime.now());
        initialStatus.setComment("Order created");
        orderStatusRepository.save(initialStatus);

        return order;
    }

    // تغییر وضعیت سفارش
    @Transactional
    public void updateOrderStatus(Long orderId, OrderStatusDTO statusDTO) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setCurrentStatus(statusDTO.getStatus());
        orderRepository.save(order);

        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setOrder(order);
        orderStatus.setStatus(statusDTO.getStatus());
        orderStatus.setStatusDate(statusDTO.getStatusDate() != null ? statusDTO.getStatusDate() : LocalDateTime.now());
        orderStatus.setComment(statusDTO.getComment());

        orderStatusRepository.save(orderStatus);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OrderDTO> getOrderById(Long id) {

        return orderRepository.findById(id).map(orderMapper::toDto);
    }

    @Override
    public OrderDTO updateOrder(Long orderId, OrderDTO orderDTO) {
        Optional<Order> existingOrderOpt = orderRepository.findById(orderId);
        if (existingOrderOpt.isPresent()) {
            Order existingOrder = existingOrderOpt.get();

            Long customerId = orderDTO.getCustomerId();
            if (customerId != null) {
                PersonEntity customer = personRepository.findById(customerId)
                        .orElseThrow(() -> new RuntimeException("Person not found with id: " + customerId));
                existingOrder.setCustomer(customer);
            }

            existingOrder.setOrderDate(orderDTO.getOrderDate());
            existingOrder.setCurrentStatus(orderDTO.getCurrentStatus());

            existingOrder.getOrderItems().clear();

            Set<OrderItem> newOrderItems = orderMapper.toEntity(orderDTO).getOrderItems();
            for (OrderItem item : newOrderItems) {
                item.setOrder(existingOrder); // تنظیم رابطه دو طرفه
            }
            existingOrder.getOrderItems().addAll(newOrderItems);

            existingOrder = orderRepository.save(existingOrder);

            return orderMapper.toDto(existingOrder);
        }
        return null;
    }



//    Optional<OrderDTO> getOrderById(Long id){ return null;}
//    @Override
//    @Transactional(readOnly = true)
//    public List<OrderDTO> getAllOrders() {
//        return orderRepository.findAll().stream()
//                .map(orderMapper::toDto)
//                .collect(Collectors.toList());
//    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return List.of();
    }

}
