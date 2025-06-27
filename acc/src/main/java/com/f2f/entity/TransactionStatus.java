package com.f2f.entity;

import com.f2f.dbc.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "TRANSACTION_STATUS")
public class TransactionStatus extends BaseEntity implements Serializable {

    @Column(name = "DATE")
    private String date ;

//    @ManyToOne
//    @JoinColumn(name = "PERSON_ID")
    private Long personId;

    @ManyToOne
    @JoinColumn(name = "TRANS_ACTION_TYPE_ID")
    private TransActionTypes invoiceActionTypes;

    @ManyToOne
    @JoinColumn(name = "TRANSACTION_ID")
    private AccountingTransaction transaction;

//    public TransactionStatus(String date, Person person, TransActionTypes invoiceActionTypes, AccountingTransaction transaction) {
//        this.date = date;
//        this.person = person;
//        this.invoiceActionTypes = invoiceActionTypes;
//        this.transaction = transaction;
//    }
}
