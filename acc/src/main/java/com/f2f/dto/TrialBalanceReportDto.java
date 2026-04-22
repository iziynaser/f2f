package com.f2f.dto;

import com.f2f.entity.AccountingPeriod;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
public class TrialBalanceReportDto {
    private AccountingPeriodDto period;
    private List<TrialBalanceLineDto> lines;
    private BigDecimal totalDebit;
    private BigDecimal totalCredit;
}
