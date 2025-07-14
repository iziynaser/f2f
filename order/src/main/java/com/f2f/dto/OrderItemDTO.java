package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDTO {
    private Long productItemId;
    private Integer quantity;
}
