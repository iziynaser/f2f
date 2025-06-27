package com.f2f.mapper;

import com.f2f.dto.OrderItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

//    @Mapping(target = "productItem.id", source = "productItemId")
//    OrderItem toEntity(OrderItemDTO dto);
//
//    @Mapping(source = "productItem.id", target = "productItemId")
//    OrderItemDTO toDto(OrderItem entity);
//
//    List<OrderItem> toEntityList(List<OrderItemDTO> dtoList);
//
//    List<OrderItemDTO> toDtoList(List<OrderItem> entityList);
}
