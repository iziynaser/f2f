package com.f2f.reporting.invoice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InvoiceTypeCountReportDTO {
    private String invoiceType;
    private Long invoiceCount;
}
