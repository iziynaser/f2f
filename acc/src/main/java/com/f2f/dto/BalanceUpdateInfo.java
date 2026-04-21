package com.f2f.dto;

import com.f2f.entity.AccountTransactionDetail;
import com.f2f.entity.AccountingPeriod;
import com.f2f.entity.AccountsChart;
import com.f2f.enums.DebitCreditType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BalanceUpdateInfo {

    public AccountsChart account;
    public AccountingPeriod period;
    public BigDecimal amountFunctional;
    public DebitCreditType debitCreditType;

    public BalanceUpdateInfo(AccountTransactionDetail d) {
        this.account = d.getAccountsChart();
        this.period = d.getAccountingTransaction().getAccountingPeriod();
        this.amountFunctional = d.getAmountFunctional();
        this.debitCreditType = d.getDebitCreditType();
    }
}
