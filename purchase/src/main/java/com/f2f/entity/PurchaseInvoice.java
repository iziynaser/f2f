package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "PURCHASE_INVOICE")
@Getter
@Setter
public class PurchaseInvoice extends BaseEntity {

    private String invoiceNumber;

    @ManyToOne
    private PersonEntity supplier;

    private LocalDate invoiceDate;

    private BigDecimal totalAmount;

    private String paymentStatus; // PAID, UNPAID, PARTIALLY_PAID

    @OneToOne
    private PurchaseOrder purchaseOrder;
}
