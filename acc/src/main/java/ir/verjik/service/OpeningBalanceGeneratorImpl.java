package ir.verjik.service;

import ir.verjik.entity.AccountingPeriod;
import ir.verjik.repository.AccountBalanceRepository;
import ir.verjik.repository.AccountingPeriodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OpeningBalanceGeneratorImpl implements OpeningBalanceGenerator {

    private final AccountingPeriodRepository periodRepository;
    private final AccountBalanceRepository balanceRepository;

    @Override
    public void generateOpening(AccountingPeriod closedPeriod) {

    }
}
