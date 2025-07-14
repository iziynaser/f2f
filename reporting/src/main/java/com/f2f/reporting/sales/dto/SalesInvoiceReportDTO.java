package com.f2f.reporting.sales.dto;

import com.f2f.enums.SalesStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class SalesInvoiceReportDTO {

    private Long id;
    private String invoiceNumber;
    private LocalDate invoiceDate;
    private SalesStatus status;
    private BigDecimal totalAmount;
}
