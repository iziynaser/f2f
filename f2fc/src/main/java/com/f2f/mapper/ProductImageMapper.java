package com.f2f.mapper;

import com.f2f.dto.ProductImageDTO;
import com.f2f.entity.product.ProductImage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductImageMapper {

    ProductImageDTO toDTO(ProductImage productImage);

    ProductImage toEntity(ProductImageDTO dto);

}
