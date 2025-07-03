package com.f2f.dto;

import lombok.Data;

@Data
public class AddToCartRequest {
    private Long productItemId;
    private Integer quantity;
}

