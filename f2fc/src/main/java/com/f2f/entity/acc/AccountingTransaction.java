package com.f2f.entity.acc;

import com.f2f.dbc.entity.BaseEntity;
import com.f2f.entity.PersonEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ACCOUNTING_TRANSACTION")
public class AccountingTransaction extends BaseEntity implements Serializable {

    @Column(name = "TRANSACTION_NUMBER")
    private String transactionNumber;

    @OneToOne
    @JoinColumn(name = "FROM_PERSON_ID")
    private PersonEntity fromPerson;

    @OneToOne
    @JoinColumn(name = "TO_PERSON_ID")
    private PersonEntity toPerson ;

    @OneToOne
    @JoinColumn(name = "TRANSACTION_TYPE_ID")
    private TransactionType transactionType ;

    @Column(name = "DESCRIPTION")
    private String description ;

    @Column(name = "ADDITIONAL_DATA")
    private String additionalInfo;

    @Column(name = "ENTRY_DATE")
    private Integer entryDate;

    @Column(name = "TRANSACTION_DATE")
    private Integer transactionDate;

    @OneToMany(mappedBy = "accountingTransaction")
    private List<TransactionDetail> transactionDetailList;

//    public AccountingTransaction(String transactionNumber, Person fromPerson, Person toPerson, TransactionType transactionType, String description, String additionalInfo, Integer entryDate, Integer transactionDate, List<TransactionDetail> transactionDetailList) {
//        this.transactionNumber = transactionNumber;
//        this.fromPerson = fromPerson;
//        this.toPerson = toPerson;
//        this.transactionType = transactionType;
//        this.description = description;
//        this.additionalInfo = additionalInfo;
//        this.entryDate = entryDate;
//        this.transactionDate = transactionDate;
//        this.transactionDetailList = transactionDetailList;
//    }
}
