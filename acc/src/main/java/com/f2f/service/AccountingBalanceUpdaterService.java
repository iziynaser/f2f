package com.f2f.service;

import com.f2f.dto.BalanceUpdateInfo;
import com.f2f.entity.AccountBalance;
import com.f2f.entity.AccountTransactionDetail;
import com.f2f.entity.AccountingPeriod;
import com.f2f.entity.AccountsChart;
import com.f2f.enums.DebitCreditType;
import com.f2f.repository.AccountBalanceRepository;
import com.f2f.repository.AccountsChartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AccountingBalanceUpdaterService {

    private final AccountBalanceRepository balanceRepository;
    private final AccountsChartRepository accountRepository;

    public AccountingBalanceUpdaterService(
            AccountBalanceRepository balanceRepository,
            AccountsChartRepository accountRepository) {
        this.balanceRepository = balanceRepository;
        this.accountRepository = accountRepository;
    }


    public void applyBalances(List<AccountTransactionDetail> details) {

        Map<String, BalanceUpdateInfo> updateMap = new HashMap<>();

        for (AccountTransactionDetail d : details) {

            AccountsChart acc = d.getAccountsChart();
            AccountingPeriod period = d.getAccountingTransaction().getAccountingPeriod();

            if (acc == null) {
                throw new IllegalStateException("Account is NULL in transaction detail");
            }

            BalanceUpdateInfo info = new BalanceUpdateInfo(d);

            String key = acc.getId() + "_" + period.getId();

            updateMap.compute(key, (k, oldVal) -> {

                if (oldVal == null) return info;

                if (info.debitCreditType == DebitCreditType.DEBIT) {
                    oldVal.amountFunctional = oldVal.amountFunctional.add(info.amountFunctional);
                } else {
                    oldVal.amountFunctional = oldVal.amountFunctional.subtract(info.amountFunctional);
                }
                return oldVal;
            });
        }

        List<AccountBalance> balList = new ArrayList<>();
        for (BalanceUpdateInfo info : updateMap.values()) {

            AccountsChart acc = info.account;
            AccountingPeriod period = info.period;
            BigDecimal net = info.amountFunctional;

//            AccountBalance bal = balanceRepository
//                    .findByAccountAndPeriod(acc, period)
//                    .orElseGet(() -> createBalance(acc, period));

            AccountBalance bal = new AccountBalance();

            if (net.compareTo(BigDecimal.ZERO) > 0) {
                bal.setDebitTotal(bal.getDebitTotal().add(net));
            } else if (net.compareTo(BigDecimal.ZERO) < 0) {
                bal.setCreditTotal(bal.getCreditTotal().add(net.abs()));
            }

            bal.setLastUpdated(LocalDateTime.now());
            balList.add(bal);
        }
        balanceRepository.saveAll(balList);
    }


    private AccountBalance createBalance(AccountsChart acc, AccountingPeriod p) {
        AccountBalance b = new AccountBalance();
        b.setAccount(acc);
        b.setPeriod(p);
        b.setDebitTotal(BigDecimal.ZERO);
        b.setCreditTotal(BigDecimal.ZERO);
        b.setOpeningBalance(BigDecimal.ZERO);
        return balanceRepository.save(b);
    }
}
