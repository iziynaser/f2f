package com.f2f.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "INVOICE_TERM")
public class InvoiceTerm implements Serializable {

    @Id
    @GeneratedValue
    @Column(name ="INVOICE_TYPE_ID")
    private Integer id;


}
