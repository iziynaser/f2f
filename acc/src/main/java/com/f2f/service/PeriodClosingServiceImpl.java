package com.f2f.service;

import com.f2f.entity.AccountBalance;
import com.f2f.entity.AccountingPeriod;
import com.f2f.enums.PeriodStatus;
import com.f2f.enums.TransactionStatus;
import com.f2f.repository.AccountBalanceRepository;
import com.f2f.repository.AccountingPeriodRepository;
import com.f2f.repository.AccountingTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PeriodClosingServiceImpl implements PeriodClosingService {

    private final AccountingPeriodRepository periodRepository;
    private final AccountingTransactionRepository transactionRepository;
    private final AccountBalanceRepository balanceRepository;
    private final OpeningBalanceGenerator openingBalanceGenerator;

    @Override
    public void closePeriod(Long periodId) {

        AccountingPeriod period = periodRepository.findById(periodId)
                .orElseThrow(() -> new RuntimeException("Period not found"));

        if (period.getIsClosed() == PeriodStatus.CLOSED)
            throw new RuntimeException("Period already closed");

        // 1. Check drafts
        boolean hasDraft = transactionRepository.existsByAccountingPeriodAndTransactionStatus(period, TransactionStatus.DRAFT);
        if (hasDraft)
            throw new RuntimeException("Cannot close period, draft transactions exist");

        // 2. Load balances of this period
        List<AccountBalance> balances = balanceRepository.findAllByPeriod(period);

        // 3. Calculate closingBalance
        for (AccountBalance b : balances) {
            BigDecimal opening = b.getOpeningBalance() != null ? b.getOpeningBalance() : BigDecimal.ZERO;
            BigDecimal debit = b.getDebitTotal() != null ? b.getDebitTotal() : BigDecimal.ZERO;
            BigDecimal credit = b.getCreditTotal() != null ? b.getCreditTotal() : BigDecimal.ZERO;

            BigDecimal closing = opening.add(debit).subtract(credit);
            b.setClosingBalance(closing);

        }

        balanceRepository.saveAll(balances);

        // 4. Close the period
        period.setIsClosed(PeriodStatus.CLOSED);
        periodRepository.save(period);

        // 5. Generate opening balances for next period
        openingBalanceGenerator.generateOpening(period);
    }
}
