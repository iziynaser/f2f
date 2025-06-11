package com.f2f.entity.acc.invoice;

import com.f2f.dbc.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "INVOICE_ITEM_TYPE")
public class InvoiceItemType extends BaseEntity implements Serializable {


    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTON")
    private String description ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InvoiceItemType(){

    }
    public InvoiceItemType(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
