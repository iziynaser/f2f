package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDTO {
    private Long productItemId;
    private Integer quantity;
    private Long unitPrice;
    private Long totalPrice;

    private ProductColorDTO color;

    private ProductSizeDTO size;

    private Long defaultPrice;

    private Long finalPrice;

    private String productTitle;

    private String cardImageUrl;

}
