package com.f2f.mapper;

import com.f2f.dto.OrderStatusDTO;
import com.f2f.entity.order.OrderStatus;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderStatusMapper {

    OrderStatus toEntity(OrderStatusDTO dto);

    OrderStatusDTO toDto(OrderStatus entity);

    List<OrderStatus> toEntityList(List<OrderStatusDTO> dtoList);

    List<OrderStatusDTO> toDtoList(List<OrderStatus> entityList);
}
