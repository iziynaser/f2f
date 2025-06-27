package com.f2f.entity.invoice;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "INVOICE_STATUS")
public class InvoiceStatus extends BaseEntity implements Serializable {

    @Column(name = "DATE")
    private String date ;

//    @ManyToOne
//    @JoinColumn(name = "PERSON_ID")
    private Long personId;

    @ManyToOne
    @JoinColumn(name = "INVOICE_ACTION_TYPE_ID")
    private InvoiceActionTypes invoiceActionTypes;

    @ManyToOne
    @JoinColumn(name = "INVOICE_ID")
    private Invoice invoice;
}
