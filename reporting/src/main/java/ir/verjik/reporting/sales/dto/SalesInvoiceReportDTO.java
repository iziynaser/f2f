package ir.verjik.reporting.sales.dto;

import ir.verjik.enums.SalesStatus;
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
