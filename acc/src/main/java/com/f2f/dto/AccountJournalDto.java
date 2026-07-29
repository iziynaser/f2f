package com.f2f.dto;

import com.f2f.entity.AccountingChart;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class AccountJournalDto {
    private AccountingChart account;
    private List<AccountJournalLine> lines;
    private BigDecimal openingBalance;
    private BigDecimal closingBalance;
}
