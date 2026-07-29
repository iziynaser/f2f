package com.f2f.service;

import com.f2f.dto.AccountTransactionDetailCreateDTO;
import com.f2f.dto.AccountingTransactionCreateDTO;
import com.f2f.entity.AccountBalance;
import com.f2f.entity.AccountingChart;
import com.f2f.entity.AccountingPeriod;
import com.f2f.enums.AccountNature;
import com.f2f.enums.DebitCreditType;
import com.f2f.repository.AccountBalanceRepository;
import com.f2f.repository.AccountingPeriodRepository;
import com.f2f.repository.AccountsChartRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SystemVoucherGeneratorService {

    private final AccountBalanceRepository balanceRepo;
    private final TransactionLifecycleManagerService transactionService;
    private final AccountsChartRepository accountRepo;
    private final AccountingPeriodRepository periodRepo;

    public SystemVoucherGeneratorService(
            AccountBalanceRepository balanceRepo,
            TransactionLifecycleManagerService transactionService,
            AccountsChartRepository accountRepo,
            AccountingPeriodRepository periodRepo
    ) {
        this.balanceRepo = balanceRepo;
        this.transactionService = transactionService;
        this.accountRepo = accountRepo;
        this.periodRepo = periodRepo;
    }

    // --------------------------------------------------------------------
    //   Close Temporary Accounts (Revenue + Expense)
    // --------------------------------------------------------------------
    public Long generateTemporaryClosingVoucher(
            Long periodId,
            Long plSummaryAccountId,
            LocalDate date
    ) {

        AccountingPeriod period = periodRepo.findById(periodId)
                .orElseThrow(() -> new RuntimeException("Period not found"));

        AccountingChart plSummary = accountRepo.findById(plSummaryAccountId)
                .orElseThrow(() -> new RuntimeException("PL Summary account not found"));

        // 1) دریافت مانده حساب‌های موقت از AccountBalance
        List<AccountBalance> allBalances = balanceRepo.findAllByPeriodId(periodId);

        List<AccountTransactionDetailCreateDTO> details = new ArrayList<>();

        BigDecimal net = BigDecimal.ZERO;

        for (AccountBalance b : allBalances) {

            AccountingChart acc = b.getAccount();

            // فقط حساب‌های سود و زیانی (موقت)
            if (acc.getAccountNature() != AccountNature.REVENUE &&
                    acc.getAccountNature() != AccountNature.EXPENSE)
                continue;

            BigDecimal closing = b.getOpeningBalance()
                    .add(b.getDebitTotal())
                    .subtract(b.getCreditTotal());

            if (closing.compareTo(BigDecimal.ZERO) == 0)
                continue;

            if (closing.compareTo(BigDecimal.ZERO) > 0) {
                // closing بدهکار → باید بستانکار شود
                details.add(new AccountTransactionDetailCreateDTO(
                        acc.getId(), closing, DebitCreditType.CREDIT
                ));

                net = net.subtract(closing);

            } else {
                // closing بستانکار → باید بدهکار شود
                closing = closing.abs();

                details.add(new AccountTransactionDetailCreateDTO(
                        acc.getId(), closing, DebitCreditType.DEBIT
                ));

                net = net.add(closing);
            }
        }

        if (details.isEmpty())
            throw new RuntimeException("No temporary balances to close");

        // 2) ثبت PL SUMMARY
        if (net.compareTo(BigDecimal.ZERO) > 0) {
            // درآمد بیشتر → سود → بستانکار PL Summary
            details.add(new AccountTransactionDetailCreateDTO(
                    plSummary.getId(), net, DebitCreditType.CREDIT
            ));
        } else {
            // هزینه بیشتر → زیان → بدهکار PL Summary
            details.add(new AccountTransactionDetailCreateDTO(
                    plSummary.getId(), net.abs(), DebitCreditType.DEBIT
            ));
        }

        // 3) ساخت و ذخیره سند
        AccountingTransactionCreateDTO voucher = new AccountingTransactionCreateDTO();
        voucher.setDate(date);
        voucher.setDescription("System Closing - Temporary Accounts");
        voucher.setDetails(details);

        //return transactionService.create(voucher).getId();
        return new Long("0");
    }

    // --------------------------------------------------------------------
    //   Close Profit/Loss (PL Summary → Retained Earnings)
    // --------------------------------------------------------------------
    public Long generateProfitLossClosingVoucher(
            Long periodId,
            Long plSummaryId,
            Long retainedEarningsId,
            LocalDate date
    ) {

        AccountingPeriod period = periodRepo.findById(periodId)
                .orElseThrow(() -> new RuntimeException("Period not found"));

        AccountingChart plSummary = accountRepo.findById(plSummaryId)
                .orElseThrow(() -> new RuntimeException("PL Summary account not found"));

        AccountingChart retained = accountRepo.findById(retainedEarningsId)
                .orElseThrow(() -> new RuntimeException("Retained Earnings account not found"));

        // پیدا کردن مانده PL Summary در این دوره
        AccountBalance b = balanceRepo.findByAccountAndPeriod(plSummary, period).orElse(null);

        if (b == null)
            throw new RuntimeException("No balance found for PL Summary in this period");

        BigDecimal net = b.getOpeningBalance()
                .add(b.getDebitTotal())
                .subtract(b.getCreditTotal());

        if (net.compareTo(BigDecimal.ZERO) == 0)
            throw new RuntimeException("PL Summary balance is zero");

        List<AccountTransactionDetailCreateDTO> details = new ArrayList<>();

        if (net.compareTo(BigDecimal.ZERO) > 0) {
            // سود → بستن PL Summary بدهکار
            details.add(new AccountTransactionDetailCreateDTO(
                    plSummary.getId(), net, DebitCreditType.DEBIT
            ));
            details.add(new AccountTransactionDetailCreateDTO(
                    retained.getId(), net, DebitCreditType.CREDIT
            ));

        } else {
            // زیان → بستن PL Summary بستانکار
            net = net.abs();
            details.add(new AccountTransactionDetailCreateDTO(
                    plSummary.getId(), net, DebitCreditType.CREDIT
            ));
            details.add(new AccountTransactionDetailCreateDTO(
                    retained.getId(), net, DebitCreditType.DEBIT
            ));
        }

        AccountingTransactionCreateDTO dto = new AccountingTransactionCreateDTO();
        dto.setDate(date);
        dto.setDescription("System Closing - Profit and Loss");
        dto.setDetails(details);

        //return transactionService.create(dto).getId();
        return new Long("0");
    }
}
