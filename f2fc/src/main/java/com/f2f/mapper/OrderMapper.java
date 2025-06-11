package com.f2f.mapper;

import com.f2f.dto.OrderDTO;
import com.f2f.entity.PersonEntity;
import com.f2f.entity.order.Order;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {OrderItemMapper.class})
public interface OrderMapper {

    @Mapping(target = "customer", source = "customerId", qualifiedByName = "idToPersonEntity")
    Order toEntity(OrderDTO dto);

    @Mapping(target = "customerId", source = "customer", qualifiedByName = "personEntityToId")
    OrderDTO toDto(Order entity);

    List<Order> toEntityList(List<OrderDTO> dtoList);

    List<OrderDTO> toDtoList(List<Order> entityList);

    @Named("personEntityToId")
    default Long personEntityToId(PersonEntity person) {
        return person != null ? person.getId() : null;
    }

    @Named("idToPersonEntity")
    default PersonEntity idToPersonEntity(Long id) {
        if (id == null) {
            return null;
        }
        PersonEntity p = new PersonEntity();
        p.setId(id);
        return p;
    }
}
