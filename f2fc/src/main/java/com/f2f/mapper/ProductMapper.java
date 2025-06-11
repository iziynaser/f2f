package com.f2f.mapper;

import com.f2f.entity.product.Product;
import com.f2f.entity.product.ProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductImageMapper.class})
public interface ProductMapper {

    public ProductDTO toDTO(Product product);

    public Product toEntity(ProductDTO productDTO);
}
