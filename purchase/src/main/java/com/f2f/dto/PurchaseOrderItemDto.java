package com.f2f.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderItemDto {
    private Long productItemId;
    private Integer quantity;
    private Long unitPrice;
}
