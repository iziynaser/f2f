package ir.verjik.mapper;

import ir.verjik.dto.ProductImageDTO;
import ir.verjik.entity.ProductImage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductImageMapper {

    ProductImageDTO toDTO(ProductImage productImage);

    ProductImage toEntity(ProductImageDTO dto);

}
