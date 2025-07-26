package com.f2f.mapper;

import com.f2f.dto.OrderItemDTO;
import com.f2f.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItem toEntity(OrderItemDTO dto);

    OrderItemDTO toDto(OrderItem entity);

    List<OrderItem> toEntityList(List<OrderItemDTO> dtoList);

    List<OrderItemDTO> toDtoList(List<OrderItem> entityList);
}
