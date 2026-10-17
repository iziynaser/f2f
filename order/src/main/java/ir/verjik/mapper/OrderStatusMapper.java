package ir.verjik.mapper;

import ir.verjik.dto.OrderStatusDTO;
import ir.verjik.entity.OrderStatus;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderStatusMapper {

    OrderStatus toEntity(OrderStatusDTO dto);

    OrderStatusDTO toDto(OrderStatus entity);

    List<OrderStatus> toEntityList(List<OrderStatusDTO> dtoList);

    List<OrderStatusDTO> toDtoList(List<OrderStatus> entityList);
}
