package com.f2f.mapper;

import com.f2f.dto.BrandDTO;
import com.f2f.entity.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "category.id", target = "categoryId")
    BrandDTO toDto(Brand brand);
}
