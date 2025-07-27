package com.f2f.dto;

import com.f2f.enums.OrderStatusEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {

    private Long id; // شناسه سفارش
    private String orderCode; // کد سفارش برای نمایش
    private Long customerId;
    private LocalDateTime orderDate;

    private LocalDate deliveryDate;
    private LocalTime deliveryTime;

    private OrderStatusEnum currentStatus; // بهتر از String
    private Long totalAmount; // جمع کل سفارش، اگر نیاز به محاسبه هست

    private List<OrderItemDTO> items;
    private List<OrderStatusDTO> statusHistory; // اختیاری برای نمایش کامل
}
