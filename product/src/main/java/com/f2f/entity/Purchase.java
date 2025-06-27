package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "PURCHAESE")
public class Purchase extends BaseEntity implements Serializable {

    private Product product;

    @Column(name = "PURCHASE_DATE")
    private Integer purchaseDate ;

    @Column(name = "SUPPLIER_PERSON")
    private Long supplierPersonId;

    @Column(name = "PURCHASE_STATUS")
    private String purchaseStatus ;

    public Purchase() {
    }

}
