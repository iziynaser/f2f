package com.f2f.entity.acc;

import com.f2f.entity.common.Person;
import com.f2f.persistence.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ACCOUNTING_TRANSACTION")
public class AccountingTransaction extends BaseEntity implements Serializable {

    @Column(name = "TRANSACTION_NUMBER")
    private String transactionNumber;

    @OneToOne
    @JoinColumn(name = "FROM_PERSON_ID")
    private Person fromPerson;

    @OneToOne
    @JoinColumn(name = "TO_PERSON_ID")
    private Person toPerson ;

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

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Integer getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Integer entryDate) {
        this.entryDate = entryDate;
    }

    public Integer getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Integer transactionDate) {
        this.transactionDate = transactionDate;
    }

    public AccountingTransaction() {
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public List<TransactionDetail> getTransactionDetailList() {
        return transactionDetailList;
    }

    public void setTransactionDetailList(List<TransactionDetail> transactionDetailList) {
        this.transactionDetailList = transactionDetailList;
    }

    public AccountingTransaction(String transactionNumber, Person fromPerson, Person toPerson, TransactionType transactionType, String description, String additionalInfo, Integer entryDate, Integer transactionDate, List<TransactionDetail> transactionDetailList) {
        this.transactionNumber = transactionNumber;
        this.fromPerson = fromPerson;
        this.toPerson = toPerson;
        this.transactionType = transactionType;
        this.description = description;
        this.additionalInfo = additionalInfo;
        this.entryDate = entryDate;
        this.transactionDate = transactionDate;
        this.transactionDetailList = transactionDetailList;
    }
}
