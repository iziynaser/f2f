package com.f2f.service;

import com.f2f.entity.*;
import com.f2f.enums.AccountNature;
import com.f2f.enums.DebitCreditType;
import com.f2f.enums.TransactionStatus;
import com.f2f.repository.AccountBalanceRepository;
import com.f2f.repository.AccountingPeriodRepository;
import com.f2f.repository.AccountingTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OpeningBalanceService {

    private final AccountBalanceRepository balanceRepository;
    private final AccountingTransactionRepository transactionRepository;
    private final TransactionLifecycleManagerService lifecycleService;
    private final NumberSequenceService sequenceService;
    private final AccountingPeriodRepository periodRepository;

    public OpeningBalanceService(AccountBalanceRepository balanceRepository,
                                 AccountingTransactionRepository transactionRepository,
                                 TransactionLifecycleManagerService lifecycleService,
                                 NumberSequenceService sequenceService,
                                 AccountingPeriodRepository periodRepository) {
        this.balanceRepository = balanceRepository;
        this.transactionRepository = transactionRepository;
        this.lifecycleService = lifecycleService;
        this.sequenceService = sequenceService;
        this.periodRepository = periodRepository;
    }

    // --------------------------------------------------------------------
    //   Generate Opening Entry For New Fiscal Year
    // --------------------------------------------------------------------
    public AccountingTransaction generateOpeningBalances(Integer previousFiscalYear,
                                                         Integer newFiscalYear,
                                                         Long companyId,
                                                         Long branchId) {

        // 1) مانده‌های سال قبل (آخرین دوره سال)
        List<AccountBalance> closingBalances =
                balanceRepository.findYearClosingBalances(
                        previousFiscalYear,
                        companyId,
                        branchId
                );

        // اگر هیچ مانده‌ای نیست، منطقی است خطا بدهیم یا لاگ کنیم
        if (closingBalances.isEmpty()) {
            throw new IllegalStateException(
                    "No closing balances found for fiscalYear=" + previousFiscalYear +
                            ", companyId=" + companyId + ", branchId=" + branchId
            );
        }

        // 2) اولین دوره سال جدید
        AccountingPeriod firstPeriod =
                periodRepository
                        .findFirstByCompanyIdAndBranchIdAndFiscalYearOrderByPeriodNumberAsc(
                                companyId,
                                branchId,
                                newFiscalYear
                        )
                        .orElseThrow(() ->
                                new IllegalStateException(
                                        "First period of new fiscal year not found for fiscalYear=" +
                                                newFiscalYear + ", companyId=" + companyId +
                                                ", branchId=" + branchId
                                )
                        );

        // 3) ساخت خطوط سند افتتاحیه
        List<AccountTransactionDetail> details =
                buildOpeningDetails(closingBalances);

        // 4) متعادل‌سازی سند (Balanced Journal)
        balanceDetails(details);

        // 5) ساخت هدر سند
        AccountingTransaction tx =
                buildOpeningTransaction(details, firstPeriod);

        // 6) ذخیره و Post کردن سند
        transactionRepository.save(tx);
        lifecycleService.changeStatus(tx, TransactionStatus.POSTED);

        // 7) آپدیت مانده‌های AccountBalance دوره اول سال جدید
        updateOpeningBalancesForNewYear(
                previousFiscalYear,
                newFiscalYear,
                companyId,
                branchId
        );

        return tx;
    }

    // --------------------------------------------------------------------
    //   Update AccountBalance for first period of new year
    // --------------------------------------------------------------------
    public void updateOpeningBalancesForNewYear(Integer previousFiscalYear,
                                                Integer newFiscalYear,
                                                Long companyId,
                                                Long branchId) {

        // مانده‌های سال قبل (آخرین دوره)
        List<AccountBalance> closingBalances =
                balanceRepository.findYearClosingBalances(
                        previousFiscalYear,
                        companyId,
                        branchId
                );

        if (closingBalances.isEmpty()) {
            // اگر رسیدیم اینجا و خالی بود، بهتر است خطای واضح بدهیم
            throw new IllegalStateException(
                    "No closing balances found for updateOpeningBalancesForNewYear. fiscalYear=" +
                            previousFiscalYear + ", companyId=" + companyId + ", branchId=" + branchId
            );
        }

        // اولین دوره سال جدید
        AccountingPeriod firstPeriod =
                periodRepository
                        .findFirstByCompanyIdAndBranchIdAndFiscalYearOrderByPeriodNumberAsc(
                                companyId,
                                branchId,
                                newFiscalYear
                        )
                        .orElseThrow(() ->
                                new IllegalStateException(
                                        "First period of new fiscal year not found for fiscalYear=" +
                                                newFiscalYear + ", companyId=" + companyId +
                                                ", branchId=" + branchId
                                )
                        );

        // تبدیل مانده‌های سال قبل → openingBalance سال جدید
        List<AccountBalance> toSave = new ArrayList<>();

        for (AccountBalance prevBalance : closingBalances) {

            BigDecimal closing =
                    prevBalance.getOpeningBalance()
                            .add(prevBalance.getDebitTotal())
                            .subtract(prevBalance.getCreditTotal());

            AccountingChart account = prevBalance.getAccount();

            AccountBalance newBalance =
                    balanceRepository
                            .findByAccountAndPeriod(account, firstPeriod)
                            .orElseGet(() -> {
                                AccountBalance b = new AccountBalance();
                                b.setAccount(account);
                                b.setPeriod(firstPeriod);
                                b.setOpeningBalance(BigDecimal.ZERO);
                                b.setDebitTotal(BigDecimal.ZERO);
                                b.setCreditTotal(BigDecimal.ZERO);
                                return b;
                            });

            newBalance.setOpeningBalance(closing);
            newBalance.setDebitTotal(BigDecimal.ZERO);
            newBalance.setCreditTotal(BigDecimal.ZERO);

            toSave.add(newBalance);
        }

        balanceRepository.saveAll(toSave);
    }

    // --------------------------------------------------------------------
    //   Build Lines (Details) from account balances
    // --------------------------------------------------------------------
    private List<AccountTransactionDetail> buildOpeningDetails(List<AccountBalance> balances) {

        List<AccountTransactionDetail> details = new ArrayList<>();

        for (AccountBalance bal : balances) {

            // اگر مدل شما AccountBalance → Account است ولی در Detail از AccountsChart استفاده می‌کنید،
            // اینجا باید تبدیل مناسب انجام شود. فرض می‌کنیم getAccount() همان AccountsChart است
            // یا این‌که typeها را در entityها Align کرده‌ای.
            AccountingChart acc = (AccountingChart) bal.getAccount();

            // فقط حساب‌های ترازنامه‌ای
            if (!isBalanceSheetAccount(acc))
                continue;

            // محاسبه closing چون closingBalance فیلد جدا نداریم
            BigDecimal closing = bal.getOpeningBalance()
                    .add(bal.getDebitTotal())
                    .subtract(bal.getCreditTotal());

            if (closing.compareTo(BigDecimal.ZERO) == 0)
                continue;

            DebitCreditType type =
                    closing.signum() > 0 ? DebitCreditType.DEBIT : DebitCreditType.CREDIT;

            AccountTransactionDetail d = new AccountTransactionDetail();
            d.setAccountingChart(acc);
            d.setAmountFunctional(closing.abs());
            d.setDebitCreditType(type);

            details.add(d);
        }

        return details;
    }

    // --------------------------------------------------------------------
    //   Balance the journal entry (force debit = credit)
    // --------------------------------------------------------------------
    private void balanceDetails(List<AccountTransactionDetail> details) {

        BigDecimal totalDebit = BigDecimal.ZERO;
        BigDecimal totalCredit = BigDecimal.ZERO;

        for (AccountTransactionDetail d : details) {
            if (d.getDebitCreditType() == DebitCreditType.DEBIT)
                totalDebit = totalDebit.add(d.getAmountFunctional());
            else
                totalCredit = totalCredit.add(d.getAmountFunctional());
        }

        BigDecimal diff = totalDebit.subtract(totalCredit);

        if (diff.compareTo(BigDecimal.ZERO) == 0)
            return; // already balanced

        AccountTransactionDetail comp = new AccountTransactionDetail();

        AccountingChart suspense = findOpeningSuspenseAccount(); // باید پیاده‌سازی شود

        comp.setAccountingChart(suspense);
        comp.setAmountFunctional(diff.abs());
        comp.setDebitCreditType(
                diff.signum() > 0
                        ? DebitCreditType.CREDIT
                        : DebitCreditType.DEBIT
        );

        details.add(comp);
    }

    // --------------------------------------------------------------------
    //   Build the header (transaction)
    // --------------------------------------------------------------------
    private AccountingTransaction buildOpeningTransaction(List<AccountTransactionDetail> details,
                                                          AccountingPeriod period) {

        AccountingTransaction tx = new AccountingTransaction();

        tx.setTransactionDate(period.getFromDate());
        tx.setDescription("OPENING BALANCE ENTRY");

        Long seq = sequenceService.next("OPENING_BALANCE");
        tx.setTransactionNumber("OB-" + seq);

        //tx.setFiscalPeriod(period); // اگر فیلد دارید، این را فعال کنید
        tx.setTransactionStatus(TransactionStatus.DRAFT);

        for (int i = 0; i < details.size(); i++) {
            AccountTransactionDetail d = details.get(i);
            d.setAccountingTransaction(tx);
            d.setSequenceId(i + 1);
        }

        tx.setAccountTransactionDetails(details);

        return tx;
    }

    // --------------------------------------------------------------------
    //   Helpers
    // --------------------------------------------------------------------
    private boolean isBalanceSheetAccount(AccountingChart acc) {
        return acc.getAccountNature() == AccountNature.ASSET
                || acc.getAccountNature() == AccountNature.LIABILITY
                || acc.getAccountNature() == AccountNature.EQUITY;
    }

    // حساب معلق / equity برای بالانس کردن سند
    private AccountingChart findOpeningSuspenseAccount() {
        // این متد را باید متناسب با سیستم خودتان پیاده کنید
        // مثلاً از table تنظیمات، یا کد ثابت، یا ریپوزیتوری AccountsChart
        throw new IllegalStateException("Opening Suspense Account must be configured");
    }
}
