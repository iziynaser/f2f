package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCategoryInfoDTO {
    private Long productId;
    private String categoryName;

    public ProductCategoryInfoDTO(Long productId, String categoryName) {
        this.productId = productId;
        this.categoryName = categoryName;
    }

    // getters and setters
}
