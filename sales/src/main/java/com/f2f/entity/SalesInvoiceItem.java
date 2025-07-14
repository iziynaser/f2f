package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "SALES_INVOICE_ITEM")
public class SalesInvoiceItem extends BaseEntity {
    @ManyToOne
    private SalesInvoice invoice;
    private Long productItemId;
    private Integer quantity;
    private BigDecimal finalPrice;
}