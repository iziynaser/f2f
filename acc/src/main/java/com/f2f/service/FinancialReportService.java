package com.f2f.service;

import com.f2f.dto.BalanceSheetDto;
import com.f2f.dto.ProfitAndLossDto;

public interface FinancialReportService {
    BalanceSheetDto getBalanceSheet(Long periodId);
    ProfitAndLossDto getProfitAndLoss(Long periodId);
}
