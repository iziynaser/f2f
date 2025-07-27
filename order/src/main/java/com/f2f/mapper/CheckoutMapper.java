package com.f2f.mapper;

import com.f2f.dto.CreateOrderRequest;
import com.f2f.dto.OrderDTO;
import com.f2f.dto.OrderItemCreateDTO;
import com.f2f.dto.OrderItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.f2f.enums.OrderStatusEnum;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", imports = {OrderStatusEnum.class, LocalDateTime.class})
public interface CheckoutMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "orderCode", ignore = true)
    @Mapping(target = "statusHistory", ignore = true)
    @Mapping(target = "items", ignore = true)
    @Mapping(target = "orderDate", expression = "java(LocalDateTime.now())")
    @Mapping(target = "currentStatus", expression = "java(OrderStatusEnum.PRE_ORDER)")
    OrderDTO toOrderDTO(CreateOrderRequest request);

    @Mapping(target = "totalPrice", ignore = true)
    @Mapping(target = "unitPrice", ignore = true)
    @Mapping(target = "defaultPrice", ignore = true)
    @Mapping(target = "finalPrice", ignore = true)
    @Mapping(target = "color", ignore = true)
    @Mapping(target = "size", ignore = true)
    @Mapping(target = "productTitle", ignore = true)
    @Mapping(target = "cardImageUrl", ignore = true)
    OrderItemDTO toOrderItemDTO(OrderItemCreateDTO dto);
}
