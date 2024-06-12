package com.f2f.entity.acc.invoice;

import com.f2f.entity.common.Person;
import com.f2f.persistence.entity.BaseEntity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "INVOICE_STATUS")
public class InvoiceStatus extends BaseEntity implements Serializable {

    @Column(name = "DATE")
    private String date ;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "INVOICE_ACTION_TYPE_ID")
    private InvoiceActionTypes invoiceActionTypes;

    @ManyToOne
    @JoinColumn(name = "INVOICE_ID")
    private Invoice invoice;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public InvoiceActionTypes getInvoiceActionTypes() {
        return invoiceActionTypes;
    }

    public void setInvoiceActionTypes(InvoiceActionTypes invoiceActionTypes) {
        this.invoiceActionTypes = invoiceActionTypes;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public InvoiceStatus() {
    }

    public InvoiceStatus(String date, Person person, InvoiceActionTypes invoiceActionTypes, Invoice invoice) {
        this.date = date;
        this.person = person;
        this.invoiceActionTypes = invoiceActionTypes;
        this.invoice = invoice;
    }
}
