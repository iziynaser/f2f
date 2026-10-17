package ir.verjik.mapper;

import ir.verjik.dto.OrderDTO;
import ir.verjik.entity.Order;
import ir.verjik.entity.OrderItem;
import ir.verjik.entity.PersonEntity;
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

