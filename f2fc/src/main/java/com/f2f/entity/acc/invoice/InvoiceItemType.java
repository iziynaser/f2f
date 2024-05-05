package com.f2f.entity.acc.invoice;

import com.f2f.persistance.entity.BaseEntity;


import javax.persistence.*;

@Entity
@Table(name = "INVOICE_ITEM_TYPE")
public class InvoiceItemType extends BaseEntity {


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

    public InvoiceItemType(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
