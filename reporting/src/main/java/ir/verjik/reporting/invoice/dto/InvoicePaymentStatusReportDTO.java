package ir.verjik.reporting.invoice.dto;

import ir.verjik.enums.PaymentStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InvoicePaymentStatusReportDTO {
    private Long invoiceId;
    private String invoiceNumber;
    private LocalDateTime invoiceDate;
    private PaymentStatus paymentStatus;  // PAID, UNPAID, PARTIALLY_PAID
    private Long totalAmount;
    private Long paidAmount;
}
