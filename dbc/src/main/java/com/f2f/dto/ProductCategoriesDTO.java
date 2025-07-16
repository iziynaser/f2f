package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCategoriesDTO {

    private Long productId ;
    private String productName ;
    private String fromDate ;
    private String toDate ;
    private String description ;
    private Long categoryId ;
    private String categoryName ;

    public ProductCategoriesDTO() {
    }
}
