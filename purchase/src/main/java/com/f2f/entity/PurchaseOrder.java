package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.enums.PurchaseOrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "PURCHASE_ORDER")
public class PurchaseOrder extends BaseEntity {

    private String orderNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private PersonEntity supplier;

    private LocalDate orderDate;

    @Enumerated(EnumType.STRING)
    private PurchaseOrderStatus status;

    private BigDecimal totalAmount;

    @OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PurchaseOrderItem> items;
}
