package ir.verjik.mapper;

import ir.verjik.dto.OrderItemDTO;
import ir.verjik.entity.OrderItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItem toEntity(OrderItemDTO dto);

    OrderItemDTO toDto(OrderItem entity);

    List<OrderItem> toEntityList(List<OrderItemDTO> dtoList);

    List<OrderItemDTO> toDtoList(List<OrderItem> entityList);
}
