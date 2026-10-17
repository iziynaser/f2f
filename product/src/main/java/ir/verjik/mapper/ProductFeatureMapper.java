package ir.verjik.mapper;

import ir.verjik.dto.ProductFeatureGroupDTO;
import ir.verjik.dto.ProductFeatureItemDTO;
import ir.verjik.dto.ProductFeatureValueDTO;
import ir.verjik.entity.ProductFeatureGroup;
import ir.verjik.entity.ProductFeatureItem;
import ir.verjik.entity.ProductFeatureValue;
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
