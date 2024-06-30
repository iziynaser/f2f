package com.f2f.entity.acc;

import com.f2f.dbc.persistence.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TRANSACTION_DETAIL")
public class TransactionDetail extends BaseEntity implements Serializable {

    @Column(name = "SEQUENCE_ID")
    private Integer sequenceId ;

    @Column(name = "AMOUNT")
    private Long amount ;

    @Column(name = "DEBIT_CREDIT_FLAG")
    private Boolean debitCreditFlag;

    @ManyToOne
    private AccountsChart accountsChart;

    @ManyToOne
    @JoinColumn(name = "ACCOUNTING_TRANSACTION_ID")
    private AccountingTransaction accountingTransaction;

    @Column(name = "DESCRIPTION")
    private String description;

    public Integer getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(Integer sequenceId) {
        this.sequenceId = sequenceId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Boolean getDebitCreditFlag() {
        return debitCreditFlag;
    }

    public void setDebitCreditFlag(Boolean debitCreditFlag) {
        this.debitCreditFlag = debitCreditFlag;
    }

    public AccountsChart getAccountsChart() {
        return accountsChart;
    }

    public void setAccountsChart(AccountsChart accountsChart) {
        this.accountsChart = accountsChart;
    }

    public AccountingTransaction getAccountingTransaction() {
        return accountingTransaction;
    }

    public void setAccountingTransaction(AccountingTransaction accountingTransaction) {
        this.accountingTransaction = accountingTransaction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TransactionDetail() {
    }

    public TransactionDetail(Integer sequenceId, Long amount, Boolean debitCreditFlag, AccountsChart accountsChart, AccountingTransaction accountingTransaction, String description) {
        this.sequenceId = sequenceId;
        this.amount = amount;
        this.debitCreditFlag = debitCreditFlag;
        this.accountsChart = accountsChart;
        this.accountingTransaction = accountingTransaction;
        this.description = description;
    }
}
