package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PURCHASE_ORDER_ITEM")
public class PurchaseOrderItem extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PURCHASE_ORDER_ID")
    private PurchaseOrder purchaseOrder;

    @Column(name = "PRODUCT_ITEM_ID", nullable = false)
    private Long productItemId;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "UNIT_PRICE")
    private Long unitPrice;

    @Column(name = "TOTAL_PRICE")
    private Long totalPrice;

    @Column(name = "EXPECTED_RECEIVE_DATE")
    private LocalDate expectedReceiveDate;

    @Column(name = "NOTE")
    private String note;
}
