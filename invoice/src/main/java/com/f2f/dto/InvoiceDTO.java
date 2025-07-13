package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class InvoiceDTO {
    private String invoiceNumber;
    private String invoiceCode;
    private LocalDateTime invoiceDate;
    private String title;
    private String message;
    private String description;
    private String paymentMethod;
    private String paymentStatus;
    private LocalDateTime paymentDate;
    private LocalDateTime dueDate;
    private Long totalAmount;
    private Long paidAmount;
    private String remarks;

    private Long referenceInvoice;  // فقط id برای referenceInvoice
    private Long creatorPerson;
    private Long fromPerson;
    private Long toPerson;

    private Set<InvoiceItemDTO> items;

    private InvoiceTypeDTO invoiceType;
    private Long orderId;
}
