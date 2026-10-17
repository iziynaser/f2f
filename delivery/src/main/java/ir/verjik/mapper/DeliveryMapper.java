package ir.verjik.mapper;

import ir.verjik.dto.DeliveryDTO;
import ir.verjik.entity.Delivery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DeliveryMapper {

    // موجودیت به DTO
    @Mapping(source = "ostan.id", target = "ostanId")
    @Mapping(source = "ostan.name", target = "ostanName")
    @Mapping(source = "shahr.id", target = "shahrId")
    @Mapping(source = "shahr.name", target = "shahrName")
    @Mapping(source = "deliveryStatus", target = "deliveryStatus")
    @Mapping(source = "deliveryDate", target = "deliveryDate", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "deliveryTime", target = "deliveryTime", dateFormat = "HH:mm:ss")
    DeliveryDTO toDTO(Delivery delivery);

    // DTO به موجودیت
    @Mapping(source = "ostanId", target = "ostan.id")
    @Mapping(source = "shahrId", target = "shahr.id")
    @Mapping(source = "deliveryStatus", target = "deliveryStatus")
    @Mapping(source = "deliveryDate", target = "deliveryDate", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "deliveryTime", target = "deliveryTime", dateFormat = "HH:mm:ss")
    Delivery toEntity(DeliveryDTO dto);
}
