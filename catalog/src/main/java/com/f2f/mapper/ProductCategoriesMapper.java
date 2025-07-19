package com.f2f.mapper;

import com.f2f.dto.ProductCategoriesDTO;
import com.f2f.entity.ProductCategories;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductCategoriesMapper {

    @Mappings({
            @Mapping(source = "category.id", target = "categoryId"),
            @Mapping(source = "category.name", target = "categoryName")
    })
    ProductCategoriesDTO toDTO(ProductCategories productCategories);
}
