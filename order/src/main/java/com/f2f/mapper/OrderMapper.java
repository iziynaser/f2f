package com.f2f.mapper;

import com.f2f.dto.OrderDTO;
import com.f2f.entity.Order;
import com.f2f.entity.OrderItem;
import com.f2f.entity.PersonEntity;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {OrderItemMapper.class, OrderStatusMapper.class})
public interface OrderMapper {

    @Mapping(target = "customer", source = "customerId", qualifiedByName = "idToPersonEntity")
    Order toEntity(OrderDTO dto);

    @Mapping(target = "customerId", source = "customer", qualifiedByName = "personEntityToId")
    @Mapping(target = "totalAmount", expression = "java(calculateTotalAmount(entity.getOrderItems()))")
    @Mapping(target = "items", source = "orderItems")
    @Mapping(target = "statusHistory", source = "statusHistory")
    OrderDTO toDto(Order entity);

    List<Order> toEntityList(List<OrderDTO> dtoList);

    List<OrderDTO> toDtoList(List<Order> entityList);

    @Named("personEntityToId")
    default Long personEntityToId(PersonEntity person) {
        return person != null ? person.getId() : null;
    }

    @Named("idToPersonEntity")
    default PersonEntity idToPersonEntity(Long id) {
        if (id == null) return null;
        PersonEntity p = new PersonEntity();
        p.setId(id);
        return p;
    }

    default Long calculateTotalAmount(Set<OrderItem> items) {
        if (items == null) return 0L;
        return items.stream()
                .mapToLong(item -> item.getTotalPrice() != null ? item.getTotalPrice() : 0L)
                .sum();
    }
}

