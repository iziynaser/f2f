package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "PURCHASE_ORDER_ITEM")
public class PurchaseOrderItem extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private PurchaseOrder purchaseOrder;

    private Long productItemId;

    private Integer quantity;

    private BigDecimal unitPrice;

    private BigDecimal totalPrice;
}
