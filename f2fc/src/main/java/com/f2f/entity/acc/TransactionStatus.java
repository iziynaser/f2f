package com.f2f.entity.acc;

import com.f2f.entity.common.Person;
import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TRANSACTION_STATUS")
public class TransactionStatus extends BaseEntity implements Serializable {

    @Column(name = "DATE")
    private String date ;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "TRANS_ACTION_TYPE_ID")
    private TransActionTypes invoiceActionTypes;

    @ManyToOne
    @JoinColumn(name = "TRANSACTION_ID")
    private AccountingTransaction transaction;

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

    public TransActionTypes getInvoiceActionTypes() {
        return invoiceActionTypes;
    }

    public void setInvoiceActionTypes(TransActionTypes invoiceActionTypes) {
        this.invoiceActionTypes = invoiceActionTypes;
    }

    public AccountingTransaction getTransaction() {
        return transaction;
    }

    public void setTransaction(AccountingTransaction transaction) {
        this.transaction = transaction;
    }

    public TransactionStatus() {
    }

    public TransactionStatus(String date, Person person, TransActionTypes invoiceActionTypes, AccountingTransaction transaction) {
        this.date = date;
        this.person = person;
        this.invoiceActionTypes = invoiceActionTypes;
        this.transaction = transaction;
    }
}
