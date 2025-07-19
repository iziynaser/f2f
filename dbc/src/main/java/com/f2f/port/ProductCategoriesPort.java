package com.f2f.port;

import com.f2f.dto.ProductCategoriesDTO;

import java.util.Optional;

public interface ProductCategoriesPort {
   Optional<ProductCategoriesDTO> getPrimaryCategoryForProduct(Long productId);
}
