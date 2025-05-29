package com.f2f.mapper;

import com.f2f.entity.product.Product;
import com.f2f.entity.product.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface ProductMapper {

    ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);
    ProductDTO toDTO(Product product);
    Product toEntity(ProductDTO productDTO);
}
