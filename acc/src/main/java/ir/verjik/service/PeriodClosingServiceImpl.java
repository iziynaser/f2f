package ir.verjik.service;

import ir.verjik.entity.AccountingPeriod;
import ir.verjik.enums.PeriodStatus;
import ir.verjik.enums.TransactionStatus;
import ir.verjik.repository.AccountingPeriodRepository;
import ir.verjik.repository.AccountingTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class PeriodClosingServiceImpl implements PeriodClosingService {

    private final AccountingPeriodRepository periodRepository;
    private final AccountingTransactionRepository transactionRepository;
    private final OpeningBalanceGenerator openingBalanceGenerator;

    @Override
    public void closePeriod(Long periodId) {

        AccountingPeriod period = periodRepository.findById(periodId)
                .orElseThrow(() -> new RuntimeException("Period not found"));

        if (period.getIsClosed() == PeriodStatus.CLOSED)
            throw new RuntimeException("Period already closed");

        // 1. Check draft transactions
        boolean hasDraft = transactionRepository
                .existsByAccountingPeriodAndTransactionStatus(
                        period,
                        TransactionStatus.DRAFT
                );

        if (hasDraft)
            throw new RuntimeException("Cannot close period, draft transactions exist");

        // 2. Close period
        period.setIsClosed(PeriodStatus.CLOSED);
        periodRepository.save(period);

        // 3. Generate opening balances for next period
        openingBalanceGenerator.generateOpening(period);
    }

    //    @Override
//    public void ClosingBalance(Long periodId) {

//        // 2. Load balances of this period
//        List<AccountBalance> balances = balanceRepository.findAllByPeriod(periodId);
//
//        // 3. Calculate closingBalance
//        for (AccountBalance b : balances) {
//            BigDecimal opening = b.getOpeningBalance() != null ? b.getOpeningBalance() : BigDecimal.ZERO;
//            BigDecimal debit = b.getDebitTotal() != null ? b.getDebitTotal() : BigDecimal.ZERO;
//            BigDecimal credit = b.getCreditTotal() != null ? b.getCreditTotal() : BigDecimal.ZERO;
//
//            BigDecimal closing = opening.add(debit).subtract(credit);
//            b.setClosingBalance(closing);
//
//        }
//
//        balanceRepository.saveAll(balances);
//    }


}
