package ir.verjik.service;

import ir.verjik.dto.TrialBalanceReportDto;

public interface TrialBalanceService {
    TrialBalanceReportDto getTrialBalance(Long periodId);
}
