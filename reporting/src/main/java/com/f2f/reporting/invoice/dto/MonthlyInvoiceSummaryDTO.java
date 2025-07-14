package com.f2f.reporting.invoice.dto;

import lombok.Data;

@Data
public class MonthlyInvoiceSummaryDTO {
    private int year;
    private int month;
    private Long salesTotal;
    private Long purchaseTotal;
}
