package com.f2f.reporting.invoice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InvoicePaymentStatusReportDTO {
    private Long invoiceId;
    private String invoiceNumber;
    private LocalDateTime invoiceDate;
    private String paymentStatus;  // PAID, UNPAID, PARTIALLY_PAID
    private Long totalAmount;
    private Long paidAmount;
}
