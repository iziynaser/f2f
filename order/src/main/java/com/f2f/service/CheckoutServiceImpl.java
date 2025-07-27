package com.f2f.service;

import com.f2f.dto.*;
import com.f2f.entity.Order;
import com.f2f.entity.OrderItem;
import com.f2f.enums.OrderStatusEnum;
import com.f2f.mapper.CheckoutMapper;
import com.f2f.port.DeliveryAccessPort;
import com.f2f.repository.OrderItemRepository;
import com.f2f.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final DeliveryAccessPort deliveryAccessPort;
    private final CheckoutMapper checkoutMapper;

    @Override
    public OrderDTO submitOrder(CreateOrderRequest request) {
        // 1. دریافت اطلاعات آدرس و اعتبارسنجی
        DeliveryDTO address = deliveryAccessPort.getDeliveryById(
                request.getDeliveryInfo().getAddressId(),
                request.getCustomerId()
        );

        // 2. ساخت Order Entity
        Order orderEntity = new Order();
        orderEntity.setOrderDate(LocalDateTime.now());  // زمان ثبت سفارش
        orderEntity.setDeliveryDate(LocalDate.parse(request.getDeliveryInfo().getDeliveryDay()));
        orderEntity.setDeliveryTime(LocalTime.parse(request.getDeliveryInfo().getDeliveryTime()));
        orderEntity.setDescription(request.getNote());
        orderEntity.setCurrentStatus(OrderStatusEnum.PRE_ORDER);
        // TODO: دریافت مشتری از PersonService یا ... و ثبت در orderEntity.setCustomer(...)

        orderEntity = orderRepository.save(orderEntity);

        // 3. پردازش اقلام سفارش
        long totalAmount = 0L;
        List<OrderItemDTO> itemDTOs = new ArrayList<>();

        for (OrderItemCreateDTO itemReq : request.getItems()) {
            OrderItem orderItemEntity = new OrderItem();
            orderItemEntity.setOrder(orderEntity);
            orderItemEntity.setProductItemId(itemReq.getProductItemId());
            orderItemEntity.setQuantity(itemReq.getQuantity());

            // قیمت‌گذاری (مثال با عدد ثابت)
            long unitPrice = 100_000L;  // ← TODO: دریافت قیمت از ProductService
            long totalPrice = unitPrice * itemReq.getQuantity();

            orderItemEntity.setUnitPrice(unitPrice);
            orderItemEntity.setTotalPrice(totalPrice);
            orderItemRepository.save(orderItemEntity);

            totalAmount += totalPrice;

            // ساخت DTO برای پاسخ
            OrderItemDTO itemDTO = new OrderItemDTO();
            itemDTO.setProductItemId(itemReq.getProductItemId());
            itemDTO.setQuantity(itemReq.getQuantity());
            itemDTO.setUnitPrice(unitPrice);
            itemDTO.setTotalPrice(totalPrice);
            itemDTOs.add(itemDTO);
        }

        // 4. ساخت و بازگرداندن پاسخ OrderDTO
        OrderDTO resultDTO = checkoutMapper.toOrderDTO(request);
        resultDTO.setId(orderEntity.getId());
        resultDTO.setOrderCode("ORD-" + orderEntity.getId());
        resultDTO.setOrderDate(orderEntity.getOrderDate());
        resultDTO.setDeliveryDate(orderEntity.getDeliveryDate());
        resultDTO.setDeliveryTime(orderEntity.getDeliveryTime());
        resultDTO.setTotalAmount(totalAmount);
        resultDTO.setItems(itemDTOs);
        resultDTO.setCurrentStatus(OrderStatusEnum.PRE_ORDER);

        return resultDTO;
    }
}
