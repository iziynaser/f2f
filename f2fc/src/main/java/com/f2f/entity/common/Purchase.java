package com.f2f.entity.common;

import com.f2f.entity.product.Product;
import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "PURCHAESE")
public class Purchase extends BaseEntity implements Serializable {

    private Product product;

    @Column(name = "PURCHASE_DATE")
    private Integer purchaseDate ;

    @Column(name = "SUPPLIER_PERSON")
    private Person supplierPerson;

    @Column(name = "PURCHASE_STATUS")
    private String purchaseStatus ;

    public Purchase() {
    }

    public Purchase(Product product, Integer purchaseDate, Person supplierPerson, String purchaseStatus) {
        this.product = product;
        this.purchaseDate = purchaseDate;
        this.supplierPerson = supplierPerson;
        this.purchaseStatus = purchaseStatus;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Integer purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Person getSupplierPerson() {
        return supplierPerson;
    }

    public void setSupplierPerson(Person supplierPerson) {
        this.supplierPerson = supplierPerson;
    }

    public String getPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchaseStatus(String purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }
}
