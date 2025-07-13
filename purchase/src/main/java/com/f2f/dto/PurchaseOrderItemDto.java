package com.f2f.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
public class PurchaseOrderItemDto {
    private Long id;
    private Long productItemId;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;
}