package com.f2f.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CreateOrderRequest {

    private Long customerId;

    private DeliveryInfoDTO deliveryInfo;

    private List<OrderItemCreateDTO> items;

    private String note; // توضیحات کاربر
}
