package com.f2f.dto;

import com.f2f.entity.AccountingPeriod;
import com.f2f.entity.AccountingChart;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BalanceUpdateInfo {

    public AccountingChart account;
    public AccountingPeriod period;
    public BigDecimal debit = BigDecimal.ZERO;
    public BigDecimal credit = BigDecimal.ZERO;

    public BalanceUpdateInfo(AccountingChart account, AccountingPeriod period) {
        this.account = account;
        this.period = period;
    }
}
