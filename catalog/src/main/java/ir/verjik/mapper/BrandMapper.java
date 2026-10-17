package ir.verjik.mapper;

import ir.verjik.dto.BrandDTO;
import ir.verjik.entity.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "category.id", target = "categoryId")
    BrandDTO toDto(Brand brand);
}
