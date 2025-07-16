package com.f2f.mapper;

import com.f2f.dto.ProductItemDTO;
import com.f2f.entity.ProductItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductItemMapper {
    ProductItemDTO toDTO(ProductItem productItem);
}
