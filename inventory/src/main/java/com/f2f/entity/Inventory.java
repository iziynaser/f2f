package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "INVENTORY")
public class Inventory extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRODUCT_ITEM_ID")
    private Long productItemId;

    @ManyToOne
    private Warehouse warehouse;

    @Column(name = "QUANTITY")
    private Integer quantity ;

    public Inventory() {
    }
}
