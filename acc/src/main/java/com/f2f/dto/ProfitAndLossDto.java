package com.f2f.dto;

import com.f2f.entity.AccountingPeriod;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProfitAndLossDto {
    private AccountingPeriodDto period;
    private BigDecimal totalRevenue;
    private BigDecimal totalExpense;
    private BigDecimal netIncome;
}
