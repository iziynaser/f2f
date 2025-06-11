package com.f2f.entity.acc;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.entity.PersonEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "TRANSACTION_STATUS")
public class TransactionStatus extends BaseEntity implements Serializable {

    @Column(name = "DATE")
    private String date ;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private PersonEntity person;

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
