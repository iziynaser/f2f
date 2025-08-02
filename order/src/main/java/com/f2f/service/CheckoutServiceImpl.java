package com.f2f.service;

import com.f2f.dto.*;
import com.f2f.entity.Order;
import com.f2f.entity.OrderItem;
import com.f2f.entity.PersonEntity;
import com.f2f.enums.OrderStatusEnum;
import com.f2f.exception.ResourceNotFoundException;
import com.f2f.mapper.CheckoutMapper;
import com.f2f.mapper.OrderMapper;
import com.f2f.mapper.PersonMapper;
import com.f2f.port.DeliveryAccessPort;
import com.f2f.repository.OrderItemRepository;
import com.f2f.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final DeliveryAccessPort deliveryAccessPort;
    private final CheckoutMapper checkoutMapper;
    private final PersonService personService;
    private final OrderMapper orderMapper;
    private final PersonMapper personMapper;

    public CheckoutServiceImpl(OrderRepository orderRepository,OrderItemRepository orderItemRepository,
                               DeliveryAccessPort deliveryAccessPort,CheckoutMapper checkoutMapper,
                               PersonService personService,OrderMapper orderMapper,PersonMapper personMapper) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.deliveryAccessPort = deliveryAccessPort;
        this.checkoutMapper = checkoutMapper;
        this.personService = personService;
        this.orderMapper = orderMapper;
        this.personMapper = personMapper;
    }

    private String generateOrderCode(Long customerId) {
        String datePart = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
        int randomNumber = new Random().nextInt(9000) + 1000; // عدد رندوم 4 رقمی
        return String.format("ORD-%d-%s-%d", customerId, datePart, randomNumber);
    }

    @Override
    public Optional<OrderDTO> submitOrder(CreateOrderRequest request) {
        DeliveryDTO address = deliveryAccessPort.getDeliveryById(
                request.getDeliveryInfo().getAddressId(), request.getCustomerId());

        if (address == null) {
            throw new ResourceNotFoundException("address.not.found", new Object[]{request.getDeliveryInfo().getAddressId()});
        }

        PersonDTO customer = personService.findById(request.getCustomerId());
        if (customer == null) {
            throw new ResourceNotFoundException("customer.not.found", new Object[]{request.getCustomerId()});
        }

        // بررسی تکراری بودن سفارش (مثلاً اگر orderCode قبلاً ایجاد شده)
        String orderCode = generateOrderCode(request.getCustomerId());
        boolean exists = orderRepository.findByOrderCode(orderCode).isPresent();
        if (exists) {
            throw new DataIntegrityViolationException("Duplicate order code: " + orderCode);
        }

        Order orderEntity = Order.builder()
                .customer(personMapper.toEntity(customer))
                .orderDate(LocalDateTime.now())
                .deliveryDate(LocalDate.parse(request.getDeliveryInfo().getDeliveryDay()))
                .deliveryTime(LocalTime.parse(request.getDeliveryInfo().getDeliveryTime()))
                .description(request.getNote())
                .currentStatus(OrderStatusEnum.PRE_ORDER)
                .orderCode(orderCode)
                //.version(1)
                //.sortPriority(0)
                .build();

        orderEntity = orderRepository.save(orderEntity);

        return Optional.of(orderMapper.toDto(orderEntity));
    }


}
