package com.f2f.entity.acc.invoice;

import com.f2f.entity.common.Person;
import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="INVOICE")
public class Invoice extends BaseEntity implements Serializable {

    @Column(name = "INVOICE_DATE")
    private String date ;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "MESSAGE")
    private String message ;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToOne
    @JoinColumn(name = "CREATOR_PERSON_ID")
    private Person creatorPerson;

    @OneToOne
    @JoinColumn(name = "FROM_PERSON_ID")
    private Person fromPerson;

    @OneToOne
    @JoinColumn(name = "TO_PERSON_ID")
    private Person toPerson;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceItem> invoiceItems;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceStatus> invoiceStatuses;

    @OneToOne
    @JoinColumn(name = "INVOICE_TYPE_ID")
    private InvoiceType invoiceType;

    public Invoice() {
    }

    public Invoice(String date, String message, String description, Person creatorPerson, Person fromPerson, Person toPerson, List<InvoiceItem> invoiceItems, List<InvoiceStatus> invoiceStatuses, InvoiceType invoiceType) {
        this.date = date;
        this.message = message;
        this.description = description;
        this.creatorPerson = creatorPerson;
        this.fromPerson = fromPerson;
        this.toPerson = toPerson;
        this.invoiceItems = invoiceItems;
        this.invoiceStatuses = invoiceStatuses;
        this.invoiceType = invoiceType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getCreatorPerson() {
        return creatorPerson;
    }

    public void setCreatorPerson(Person creatorPerson) {
        this.creatorPerson = creatorPerson;
    }

    public Person getFromPerson() {
        return fromPerson;
    }

    public void setFromPerson(Person fromPerson) {
        this.fromPerson = fromPerson;
    }

    public Person getToPerson() {
        return toPerson;
    }

    public void setToPerson(Person toPerson) {
        this.toPerson = toPerson;
    }

    public List<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    public List<InvoiceStatus> getInvoiceStatuses() {
        return invoiceStatuses;
    }

    public void setInvoiceStatuses(List<InvoiceStatus> invoiceStatuses) {
        this.invoiceStatuses = invoiceStatuses;
    }

    public InvoiceType getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(InvoiceType invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
