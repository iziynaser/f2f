package com.f2f.service;

import com.f2f.dto.LedgerFilter;
import com.f2f.dto.SubsidiaryLedgerLine;
import com.f2f.dto.SubsidiaryLedgerReport;
import com.f2f.entity.*;
import com.f2f.enums.DebitCreditType;
import com.f2f.repository.AccountBalanceRepository;
import com.f2f.repository.AccountTransactionDetailRepository;
import com.f2f.repository.AccountingPeriodRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class SubsidiaryLedgerReportService {

    private final AccountTransactionDetailRepository detailRepo;
    private final AccountBalanceRepository balanceRepo;
    private final AccountingPeriodRepository periodRepo;

    public SubsidiaryLedgerReportService(
            AccountTransactionDetailRepository detailRepo,
            AccountBalanceRepository balanceRepo,
            AccountingPeriodRepository periodRepo) {

        this.detailRepo = detailRepo;
        this.balanceRepo = balanceRepo;
        this.periodRepo = periodRepo;
    }

    public SubsidiaryLedgerReport getSubsidiaryLedger(LedgerFilter filter) {

        List<AccountTransactionDetail> details =
                detailRepo.findLedgerLines(
                        filter.getAccountId(),
                        filter.getFromDate(),
                        filter.getToDate()
                );

        if (details.isEmpty()) {
            return new SubsidiaryLedgerReport();
        }

        AccountingChart account = details.get(0).getAccountingChart();

        BigDecimal opening =
                calculateOpeningBalance(account.getId(), filter.getFromDate());

        BigDecimal balance = opening;

        List<SubsidiaryLedgerLine> lines = new ArrayList<>();

        for (AccountTransactionDetail d : details) {

            AccountingTransaction t = d.getAccountingTransaction();

            BigDecimal amount =
                    d.getAmountFunctional() != null
                            ? d.getAmountFunctional()
                            : BigDecimal.ZERO;

            String counterAccounts =
                    t.getAccountTransactionDetails()
                            .stream()
                            .filter(x -> !x.getId().equals(d.getId()))
                            .map(x -> x.getAccountingChart().getAccountCode())
                            .distinct()
                            .collect(Collectors.joining(", "));

            if (d.getDebitCreditType() == DebitCreditType.DEBIT) {
                balance = balance.add(amount);
            } else {
                balance = balance.subtract(amount);
            }

            BigDecimal debitAmount = d.getDebitCreditType() == DebitCreditType.DEBIT ? amount : BigDecimal.ZERO ;
            BigDecimal creditAmount = d.getDebitCreditType() == DebitCreditType.CREDIT ? amount : BigDecimal.ZERO;

            lines.add(new SubsidiaryLedgerLine(
                    t.getTransactionDate(),
                    t.getTransactionNumber(),
                    t.getDescription(),
                    counterAccounts,
                    debitAmount,
                    creditAmount,
                    balance
            ));
        }

        SubsidiaryLedgerReport rep = new SubsidiaryLedgerReport();

        rep.setAccount(account);
        rep.setOpeningBalance(opening);
        rep.setClosingBalance(balance);
        rep.setLines(lines);

        return rep;
    }

    private BigDecimal calculateOpeningBalance(Long accountId, LocalDate fromDate) {

        AccountingPeriod period =
                periodRepo.findPeriodByDate(fromDate)
                        .orElseThrow(() ->
                                new IllegalArgumentException("Invalid period"));

        AccountBalance bal =
                balanceRepo.findByAccountIdAndPeriodId(accountId, period.getId())
                        .orElse(null);

        BigDecimal opening =
                bal != null ? bal.getOpeningBalance() : BigDecimal.ZERO;

        BigDecimal movement =
                detailRepo.sumMovementBeforeDate(accountId, fromDate)
                        .orElse(BigDecimal.ZERO);

        return opening.add(movement);
    }
}
