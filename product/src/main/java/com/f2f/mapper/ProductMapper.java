package com.f2f.mapper;

import com.f2f.dto.ProductDTO;
import com.f2f.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductImageMapper.class})
public interface ProductMapper {

    public ProductDTO toDTO(Product product);

    public Product toEntity(ProductDTO productDTO);
}
