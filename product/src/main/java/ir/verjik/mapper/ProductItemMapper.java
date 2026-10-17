package ir.verjik.mapper;

import ir.verjik.dto.ProductItemDTO;
import ir.verjik.entity.ProductItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductItemMapper {
    ProductItemDTO toDTO(ProductItem productItem);
}
