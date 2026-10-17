package ir.verjik.service;

import ir.verjik.entity.AccountBalance;
import ir.verjik.entity.AccountingPeriod;
import ir.verjik.enums.PeriodStatus;
import ir.verjik.repository.AccountBalanceRepository;
import ir.verjik.repository.AccountingPeriodRepository;
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
