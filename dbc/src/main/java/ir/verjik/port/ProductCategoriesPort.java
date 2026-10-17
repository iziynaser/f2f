package ir.verjik.port;

import ir.verjik.dto.ProductCategoriesDTO;

import java.util.Optional;

public interface ProductCategoriesPort {
   Optional<ProductCategoriesDTO> getPrimaryCategoryForProduct(Long productId);
}
