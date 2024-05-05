package com.f2f.entity.acc.invoice;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "INVOICE_TYPE")
public class InvoiceType implements Serializable {

    @Id
    @GeneratedValue
    @Column(name ="INVOICE_TYPE_ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTON")
    private String description ;

    @Column(name="TYPE")
    private String type ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public InvoiceType() {
    }

    public InvoiceType(String name, String description, String type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public InvoiceType(Integer id) {
        this.id = id;
    }
}
