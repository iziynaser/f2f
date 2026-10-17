package ir.verjik.reporting.purchase.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SupplierPerformanceReportDTO {
    private Long supplierId;
    private String supplierName;
    private Long totalOrders;
    private BigDecimal totalOrderAmount;
    private Long paidInvoices;
    private Long unpaidInvoices;
}
