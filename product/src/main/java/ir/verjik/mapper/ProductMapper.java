package ir.verjik.mapper;

import ir.verjik.dbc.dto.ProductDTO;
import ir.verjik.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductImageMapper.class})
public interface ProductMapper {

    public ProductDTO toDTO(Product product);

    public Product toEntity(ProductDTO productDTO);
}
