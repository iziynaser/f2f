package com.f2f.entity.common;

import com.f2f.entity.acc.invoice.Invoice;
import com.f2f.entity.product.Product;
import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "SALES")
public class Sales extends BaseEntity implements Serializable {

    private Product product;

    private Invoice invoice;

    @Column(name = "SALES_DATE")
    private Integer salesDate;

    public Sales() {
    }

    public Sales(Product product, Invoice invoice, Integer salesDate) {
        this.product = product;
        this.invoice = invoice;
        this.salesDate = salesDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Integer getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Integer salesDate) {
        this.salesDate = salesDate;
    }
}
