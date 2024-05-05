package com.f2f.entity.acc.invoice;

import javax.persistence.*;
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
