package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

@Entity
public class SalesInvoiceItem extends BaseEntity {
    @ManyToOne
    private SalesInvoice invoice;
    private Long productItemId;
    private Integer quantity;
    private BigDecimal finalPrice;
}