package ir.verjik.service;

import ir.verjik.dto.BalanceSheetDto;
import ir.verjik.dto.ProfitAndLossDto;

public interface FinancialReportService {
    BalanceSheetDto getBalanceSheet(Long periodId);
    ProfitAndLossDto getProfitAndLoss(Long periodId);
}
