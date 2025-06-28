package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "INVOICE_TYPE")
public class InvoiceType  extends BaseEntity implements Serializable {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTON")
    private String description ;

    @Column(name="TYPE")
    private String type ;

    public InvoiceType(String name, String description, String type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

}
