package com.f2f.dto;

import com.f2f.entity.AccountingPeriod;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class BalanceSheetDto {
    private AccountingPeriodDto period;
    private List<BalanceSheetSectionDto> sections;
    private BigDecimal totalAssets;
    private BigDecimal totalLiabilities;
    private BigDecimal totalEquity;
}

