package com.f2f.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderDetailDto {
    private Long orderId;
    private Long supplierId;
    private LocalDateTime orderDate;
    private String status;
    private List<PurchaseOrderItemDto> items;
}