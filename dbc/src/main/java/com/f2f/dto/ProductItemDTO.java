package com.f2f.dto;

import com.f2f.entity.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductItemDTO {

    private long id;

    private com.f2f.dto.ProductDTO product;

    private BrandDTO brand;

    private ProductColorDTO color;

    private ProductSizeDTO size;

    private Long defaultPrice;

    private Long finalPrice;
    private boolean hasLowStock;
    private int stockQuantity;
    private Long discountValue;

    private Integer salesCount;

    private Integer remainingCount ;

    private boolean available;

    private ProductPriceDTO productPrice;

}
