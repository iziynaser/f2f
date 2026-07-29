package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TrialBalanceRow {
    private Long accountId;
    private String accountCode;
    private String accountName;
    private BigDecimal debitTotal;
    private BigDecimal creditTotal;
    private BigDecimal balance;
}
