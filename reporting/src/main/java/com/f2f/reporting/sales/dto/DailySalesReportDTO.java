package com.f2f.reporting.sales.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class DailySalesReportDTO {
    private LocalDate date;
    private Long invoiceCount;
    private BigDecimal totalAmount;
}
