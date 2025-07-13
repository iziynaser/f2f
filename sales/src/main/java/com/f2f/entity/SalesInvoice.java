package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.enums.SalesStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class SalesInvoice extends BaseEntity {
    private String invoiceNumber;
    private Long customerId;
    private LocalDate invoiceDate;

    @Enumerated(EnumType.STRING)
    private SalesStatus status;

    private BigDecimal totalAmount;
}