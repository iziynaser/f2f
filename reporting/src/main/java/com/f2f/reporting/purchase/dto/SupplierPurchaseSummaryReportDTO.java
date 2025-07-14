package com.f2f.reporting.purchase.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SupplierPurchaseSummaryReportDTO {
    private Long supplierId;
    private String supplierName;
    private Long invoiceCount;
    private BigDecimal totalAmount;
}
