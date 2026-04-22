package com.f2f.service;

import com.f2f.entity.AccountBalance;
import com.f2f.entity.AccountingPeriod;
import com.f2f.enums.PeriodStatus;
import com.f2f.repository.AccountBalanceRepository;
import com.f2f.repository.AccountingPeriodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PeriodOpeningServiceImpl implements PeriodOpeningService {

    private final AccountingPeriodRepository periodRepository;
    private final AccountBalanceRepository balanceRepository;

    @Override
    public void openPeriod(Long periodId) {

        AccountingPeriod period = periodRepository.findById(periodId)
                .orElseThrow(() -> new RuntimeException("Period not found"));

        if (period.getIsClosed() == PeriodStatus.OPENED)
            throw new RuntimeException("Period already open");

        // Ensure opening balances exist
        List<AccountBalance> balances = balanceRepository.findAllByPeriod(period);

        if (balances.isEmpty()) {
            throw new RuntimeException("Opening balances not generated yet");
        }

        period.setIsClosed(PeriodStatus.OPENED);
        periodRepository.save(period);
    }
}
