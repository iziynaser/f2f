package ir.verjik.service;

import ir.verjik.dto.AccountBalanceDTO;
import ir.verjik.dto.AccountBalanceRangeDTO;
import ir.verjik.dto.BalanceGroupDTO;
import ir.verjik.entity.AccountBalance;
import ir.verjik.entity.AccountingPeriod;
import ir.verjik.repository.AccountBalanceRepository;
import ir.verjik.repository.AccountTransactionDetailRepository;
import ir.verjik.repository.AccountingPeriodRepository;
import ir.verjik.repository.AccountingTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class AccountBalanceQueryService {

    private final AccountBalanceRepository balanceRepo;
    private final AccountTransactionDetailRepository detailRepo;
    private final AccountingTransactionRepository transactionRepo;
    private final AccountingPeriodRepository periodRepo;

    public AccountBalanceQueryService(AccountBalanceRepository balanceRepo,
                                      AccountTransactionDetailRepository detailRepo,
                                      AccountingTransactionRepository transactionRepo,
                                      AccountingPeriodRepository periodRepo) {
        this.balanceRepo = balanceRepo;
        this.detailRepo = detailRepo;
        this.transactionRepo = transactionRepo;
        this.periodRepo = periodRepo;
    }

    // --------------------------------------------------------------------------------------------
    // 1) مانده همه حساب‌ها در یک دوره
    // --------------------------------------------------------------------------------------------
    public List<AccountBalanceDTO> getBalancesByPeriod(Long periodId) {

        List<AccountBalance> balances = balanceRepo.findAllByPeriodId(periodId);

        return balances.stream()
                .map(this::toDto)
                .toList();
    }

    private AccountBalanceDTO toDto(AccountBalance b) {

        BigDecimal closing = b.getOpeningBalance()
                .add(b.getDebitTotal())
                .subtract(b.getCreditTotal());

        return new AccountBalanceDTO(
                b.getAccount().getId(),
                b.getAccount().getAccountCode(),
                b.getAccount().getName(),
                b.getOpeningBalance(),
                b.getDebitTotal(),
                b.getCreditTotal(),
                closing
        );
    }


    // --------------------------------------------------------------------------------------------
    // 2) مانده بازه تاریخی با احترام به دوره‌های مالی (نسخه استاندارد ERP)
    // --------------------------------------------------------------------------------------------
    public AccountBalanceRangeDTO getAccountBalanceInRange(
            Long accountId, LocalDate from, LocalDate to) {

        // پیدا کردن آخرین دوره %قبل از From%
        AccountingPeriod fromPeriod =
                periodRepo.findPeriodByDate(from)
                        .orElseThrow(() -> new IllegalArgumentException("Invalid period for date " + from));

        // مانده افتتاحیه از AccountBalance
        AccountBalance bal = balanceRepo.findByAccountIdAndPeriodId(accountId, fromPeriod.getId())
                .orElse(null);

        BigDecimal opening = (bal != null) ? bal.getOpeningBalance() : BigDecimal.ZERO;

        // گردش قبل از from در همان دوره
        BigDecimal periodMovementBefore =
                detailRepo.sumMovementBeforeDate(accountId, from)
                        .orElse(BigDecimal.ZERO);

        opening = opening.add(periodMovementBefore);

        // گردش بازه
        BigDecimal debit = detailRepo.sumDebitBetween(accountId, from, to)
                .orElse(BigDecimal.ZERO);

        BigDecimal credit = detailRepo.sumCreditBetween(accountId, from, to)
                .orElse(BigDecimal.ZERO);

        BigDecimal closing = opening.add(debit).subtract(credit);

        return new AccountBalanceRangeDTO(
                accountId, opening, debit, credit, closing
        );
    }


    // --------------------------------------------------------------------------------------------
    // 3) جمع‌بندی سطحی → بدون خطر substring + امن
    // --------------------------------------------------------------------------------------------
    public List<BalanceGroupDTO> getBalanceSummaryByLevel(Long periodId, int level) {

        List<AccountBalance> balances = balanceRepo.findByPeriod(periodId);

        Map<String, List<AccountBalance>> groups =
                balances.stream().collect(Collectors.groupingBy(b -> {
                    String code = b.getAccount().getAccountCode();
                    return (code.length() >= level) ? code.substring(0, level) : code;
                }));

        List<BalanceGroupDTO> result = new ArrayList<>();

        groups.forEach((grp, list) -> {

            BigDecimal opening = list.stream()
                    .map(AccountBalance::getOpeningBalance)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal debit = list.stream()
                    .map(AccountBalance::getDebitTotal)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal credit = list.stream()
                    .map(AccountBalance::getCreditTotal)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal closing = opening.add(debit).subtract(credit);

            result.add(new BalanceGroupDTO(
                    grp, opening, debit, credit, closing
            ));
        });

        return result;
    }


    // --------------------------------------------------------------------------------------------
    // 4) گزارش بازه تاریخی ساده (ولی اصلاح‌شده و POSTED-safe)
    // --------------------------------------------------------------------------------------------
    public AccountBalanceDTO getAccountBalanceInDateRange(Long accountId, LocalDate from, LocalDate to) {

        // گردش بازه
        BigDecimal debit = detailRepo.sumDebitInDateRange(accountId, from, to)
                .orElse(BigDecimal.ZERO);

        BigDecimal credit = detailRepo.sumCreditInDateRange(accountId, from, to)
                .orElse(BigDecimal.ZERO);

        // فقط مانده قبل از از تاریخ → از openingBalance دوره و گردش ابتدای آن
        // (بدون وابستگی به Transaction کل تاریخ)
        AccountingPeriod fromPeriod =
                periodRepo.findPeriodByDate(from)
                        .orElseThrow(() -> new IllegalArgumentException("Invalid period"));

        AccountBalance bal =
                balanceRepo.findByAccountIdAndPeriodId(accountId, fromPeriod.getId())
                        .orElse(null);

        BigDecimal opening = (bal != null) ? bal.getOpeningBalance() : BigDecimal.ZERO;

        BigDecimal earlyMovement =
                detailRepo.sumMovementBeforeDate(accountId, from)
                        .orElse(BigDecimal.ZERO);

        opening = opening.add(earlyMovement);

        BigDecimal closing = opening.add(debit).subtract(credit);

        return new AccountBalanceDTO(
                accountId,
                null,
                null,
                opening,
                debit,
                credit,
                closing
        );
    }
}
