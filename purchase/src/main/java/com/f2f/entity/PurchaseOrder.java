package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PURCHASE_ORDER")
public class PurchaseOrder extends BaseEntity {

    @Column(name = "ORDER_CODE", unique = true)
    private String orderCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUPPLIER_ID")
    private PersonEntity supplier;

    @Column(name = "ORDER_DATE")
    private LocalDate orderDate;

    @Column(name = "STATUS")
    private String status; // NEW, SENT, RECEIVED, CANCELLED

    @Column(name = "NOTES")
    private String notes;

    @OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PurchaseOrderItem> items = new ArrayList<>();
}
