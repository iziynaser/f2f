package com.f2f.entity.acc.invoice;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.entity.PersonEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "INVOICE_STATUS")
public class InvoiceStatus extends BaseEntity implements Serializable {

    @Column(name = "DATE")
    private String date ;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private PersonEntity person;

    @ManyToOne
    @JoinColumn(name = "INVOICE_ACTION_TYPE_ID")
    private InvoiceActionTypes invoiceActionTypes;

    @ManyToOne
    @JoinColumn(name = "INVOICE_ID")
    private Invoice invoice;
}
