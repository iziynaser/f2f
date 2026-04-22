package com.f2f.service;

import com.f2f.dto.TrialBalanceReportDto;

public interface TrialBalanceService {
    TrialBalanceReportDto getTrialBalance(Long periodId);
}
