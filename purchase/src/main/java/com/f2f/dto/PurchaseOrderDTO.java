package com.f2f.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class PurchaseOrderDTO {
    private Long id;
    private String orderNumber;
    private Long supplierId;
    private LocalDate orderDate;
    private String status;
    private BigDecimal totalAmount;
    private List<PurchaseOrderItemDto> items;
}