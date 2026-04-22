package com.f2f.service;

import com.f2f.entity.AccountBalance;
import com.f2f.entity.AccountingPeriod;
import com.f2f.repository.AccountBalanceRepository;
import com.f2f.repository.AccountingPeriodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
