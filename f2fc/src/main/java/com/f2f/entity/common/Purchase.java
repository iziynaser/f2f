package com.f2f.entity.common;

import com.f2f.entity.PersonEntity;
import com.f2f.entity.product.Product;
import com.f2f.dbc.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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
    private PersonEntity supplierPerson;

    @Column(name = "PURCHASE_STATUS")
    private String purchaseStatus ;

    public Purchase() {
    }

    public Purchase(Product product, Integer purchaseDate, PersonEntity supplierPerson, String purchaseStatus) {
        this.product = product;
        this.purchaseDate = purchaseDate;
        this.supplierPerson = supplierPerson;
        this.purchaseStatus = purchaseStatus;
    }
}
