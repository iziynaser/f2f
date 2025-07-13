package com.f2f.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderRequestDto {
    private Long supplierId;
    private List<PurchaseOrderItemDto> items;
}
