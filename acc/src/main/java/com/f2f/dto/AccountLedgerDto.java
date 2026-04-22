package com.f2f.dto;

import com.f2f.entity.AccountsChart;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class AccountLedgerDto {
    private AccountsChartDto account;
    private List<LedgerEntryDto> entries;
    private BigDecimal openingBalance;
    private BigDecimal closingBalance;
}
