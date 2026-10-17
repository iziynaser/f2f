package ir.verjik.mapper;

import ir.verjik.dto.CategoryTreeDTO;
import ir.verjik.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(target = "subCategories", source = "subCategories")
    CategoryTreeDTO toCategoryTreeDTO(Category category);

    List<CategoryTreeDTO> toCategoryTreeDTOList(List<Category> categories);
}
