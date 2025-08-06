package com.f2f.mapper;

import com.f2f.dto.ProductFeatureGroupDTO;
import com.f2f.dto.ProductFeatureItemDTO;
import com.f2f.dto.ProductFeatureValueDTO;
import com.f2f.entity.ProductFeatureGroup;
import com.f2f.entity.ProductFeatureItem;
import com.f2f.entity.ProductFeatureValue;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductFeatureMapper {

    ProductFeatureValueDTO toValueDTO(ProductFeatureValue entity);

    @Mapping(source = "featureItems", target = "values")
    ProductFeatureItemDTO toItemDTO(ProductFeatureItem entity);

    @Mapping(source = "features", target = "items")
    ProductFeatureGroupDTO toGroupDTO(ProductFeatureGroup entity);

    List<ProductFeatureGroupDTO> toGroupDTOs(List<ProductFeatureGroup> entities);
}
