package com.f2f.entity.invoice;

import jakarta.persistence.*;


import java.io.Serializable;

@Entity
@Table(name = "INVOICE_TERM")
public class InvoiceTerm implements Serializable {

    @Id
    @GeneratedValue
    @Column(name ="INVOICE_TYPE_ID")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InvoiceTerm() {
    }


}
