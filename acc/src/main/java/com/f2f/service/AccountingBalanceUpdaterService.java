package com.f2f.service;

import com.f2f.dto.BalanceUpdateInfo;
import com.f2f.entity.AccountBalance;
import com.f2f.entity.AccountTransactionDetail;
import com.f2f.entity.AccountingChart;
import com.f2f.entity.AccountingPeriod;
import com.f2f.enums.DebitCreditType;
import com.f2f.repository.AccountBalanceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional
public class AccountingBalanceUpdaterService {

    private final AccountBalanceRepository balanceRepository;

    public AccountingBalanceUpdaterService(
            AccountBalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }




    private AccountBalance createBalance(AccountingChart acc, AccountingPeriod p) {
        AccountBalance b = new AccountBalance();
        b.setAccount(acc);
        b.setPeriod(p);
        b.setDebitTotal(BigDecimal.ZERO);
        b.setCreditTotal(BigDecimal.ZERO);
        b.setOpeningBalance(BigDecimal.ZERO);
        b.setLastUpdated(LocalDateTime.now());
        return b;//balanceRepository.save(b);
    }

    private void propagateToParents(
            AccountingChart account,
            AccountingPeriod period,
            BigDecimal debit,
            BigDecimal credit
    ) {

        AccountingChart parent = account.getParentAccount();

        while (parent != null) {

            AccountingChart finalParent = parent;
            AccountBalance parentBalance =
                    balanceRepository
                            .findByAccountAndPeriod(parent, period)
                            .orElseGet(() -> createBalance(finalParent, period));

            if (parentBalance.getDebitTotal() == null)
                parentBalance.setDebitTotal(BigDecimal.ZERO);

            if (parentBalance.getCreditTotal() == null)
                parentBalance.setCreditTotal(BigDecimal.ZERO);

            parentBalance.setDebitTotal(
                    parentBalance.getDebitTotal().add(debit)
            );

            parentBalance.setCreditTotal(
                    parentBalance.getCreditTotal().add(credit)
            );

            parentBalance.setLastUpdated(LocalDateTime.now());

            balanceRepository.save(parentBalance);

            parent = parent.getParentAccount();
        }
    }

    public void applyBalances(List<AccountTransactionDetail> details) {

        Map<String, BalanceUpdateInfo> map = new HashMap<>();

        for (AccountTransactionDetail d : details) {

            AccountingChart acc = d.getAccountingChart();
            AccountingPeriod period = d.getAccountingTransaction().getAccountingPeriod();

            if (acc == null)
                throw new IllegalStateException("Account is NULL in transaction detail");

            String key = acc.getId() + "_" + period.getId();

            map.compute(key, (k, val) -> {

                if (val == null)
                    val = new BalanceUpdateInfo(acc, period);

                BigDecimal amount = d.getAmountFunctional();

                if (d.getDebitCreditType() == DebitCreditType.DEBIT) {
                    val.debit = val.debit.add(amount);
                } else {
                    val.credit = val.credit.add(amount);
                }

                return val;
            });
        }

        List<AccountBalance> balances = new ArrayList<>();

        for (BalanceUpdateInfo info : map.values()) {

            AccountBalance bal =
                    balanceRepository
                            .findByAccountAndPeriod(info.account, info.period)
                            .orElseGet(() -> createBalance(info.account, info.period));

            if (bal.getDebitTotal() == null)
                bal.setDebitTotal(BigDecimal.ZERO);

            if (bal.getCreditTotal() == null)
                bal.setCreditTotal(BigDecimal.ZERO);

            bal.setDebitTotal(
                    bal.getDebitTotal().add(info.debit)
            );

            bal.setCreditTotal(
                    bal.getCreditTotal().add(info.credit)
            );

            bal.setLastUpdated(LocalDateTime.now());

            balances.add(bal);

            propagateToParents(
                    info.account,
                    info.period,
                    info.debit,
                    info.credit
            );
        }

        balanceRepository.saveAll(balances);
    }


}




/*
public void applyBalances(List<AccountTransactionDetail> details) {

    Map<String, BalanceUpdateInfo> map = new HashMap<>();

    for (AccountTransactionDetail d : details) {

        AccountsChart acc = d.getAccountsChart();
        AccountingPeriod period = d.getAccountingTransaction().getAccountingPeriod();

        String key = acc.getId() + "_" + period.getId();

        map.compute(key, (k, val) -> {

            if (val == null) {
                val = new BalanceUpdateInfo(acc, period);
            }

            if (d.getDebitCreditType() == DebitCreditType.DEBIT) {
                val.debit = val.debit.add(d.getAmountFunctional());
            } else {
                val.credit = val.credit.add(d.getAmountFunctional());
            }

            return val;
        });
    }

    List<AccountBalance> balList = new ArrayList<>();

    for (BalanceUpdateInfo info : map.values()) {

        AccountBalance bal =
            balanceRepository.findByAccountAndPeriod(info.account, info.period)
            .orElseGet(() -> createBalance(info.account, info.period));

        bal.setDebitTotal(
            bal.getDebitTotal().add(info.debit)
        );

        bal.setCreditTotal(
            bal.getCreditTotal().add(info.credit)
        );

        bal.setLastUpdated(LocalDateTime.now());

        balList.add(bal);
    }

    balanceRepository.saveAll(balList);
}

 */

/*
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

            AccountBalance bal;
            Optional<AccountBalance> obl = balanceRepository.findByAccountAndPeriod(acc, period);
            if(obl.isPresent()) {
                 bal = obl.get();
            }else{
                bal = createBalance(acc, period);
            };

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

 */