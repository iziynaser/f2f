package ir.verjik.mapper;

import ir.verjik.dto.ProductCategoriesDTO;
import ir.verjik.entity.ProductCategories;
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
