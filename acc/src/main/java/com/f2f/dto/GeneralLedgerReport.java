package com.f2f.dto;

import com.f2f.entity.AccountingChart;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
public class GeneralLedgerReport {
    private AccountingChart account;
    private BigDecimal openingBalance;
    private BigDecimal closingBalance;
    private List<GeneralLedgerLine> lines;
}