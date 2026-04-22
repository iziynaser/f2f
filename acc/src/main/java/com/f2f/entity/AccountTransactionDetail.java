package com.f2f.entity;


import com.f2f.dbc.entity.BaseEntity;
import com.f2f.enums.DebitCreditType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "TRANSACTION_DETAIL")
public class AccountTransactionDetail extends BaseEntity implements Serializable {

    @Column(name = "SEQUENCE_ID")
    private Integer sequenceId ;

    @Column(name = "amountFunctional")
    private BigDecimal amountFunctional; // مقدار در ارز مبنا

    @Column(name = "amountTransactionCurrency")
    private BigDecimal amountTransactionCurrency;

    @ManyToOne
    @JoinColumn(name = "FLOATING_DETAIL_ID")
    private FloatingDetail floatingDetail;

    @Column(name = "DEBIT_CREDIT",nullable = false)
    private DebitCreditType debitCreditType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID",nullable = false)
    private AccountsChart accountsChart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNTING_TRANSACTION_ID",nullable = false)
    private AccountingTransaction accountingTransaction;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name="CURRENCY_ID", nullable = false)
    private Currency currency;

    @Column(name = "EXCHANGE_RATE", nullable = false)
    private BigDecimal exchangeRate;


    public AccountTransactionDetail() {
    }

    public AccountTransactionDetail(Integer sequenceId, DebitCreditType debitCreditType, AccountsChart accountsChart, AccountingTransaction accountingTransaction, String description) {
        this.sequenceId = sequenceId;
        this.debitCreditType = debitCreditType;
        this.accountsChart = accountsChart;
        this.accountingTransaction = accountingTransaction;
        this.description = description;
    }
}
