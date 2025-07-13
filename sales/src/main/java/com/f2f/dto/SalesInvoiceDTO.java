package com.f2f.dto;

import com.f2f.enums.SalesStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class SalesInvoiceDTO {
    private Long id;
    private String invoiceNumber;
    private Long customerId;
    private LocalDate invoiceDate;
    private SalesStatus status;
    private BigDecimal totalAmount;
}
