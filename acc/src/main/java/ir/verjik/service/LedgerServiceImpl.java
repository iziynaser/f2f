package ir.verjik.service;

import ir.verjik.dto.*;
import ir.verjik.entity.AccountBalance;
import ir.verjik.entity.AccountTransactionDetail;
import ir.verjik.entity.AccountingPeriod;
import ir.verjik.entity.AccountingChart;
import ir.verjik.enums.DebitCreditType;
import ir.verjik.repository.AccountBalanceRepository;
import ir.verjik.repository.AccountTransactionDetailRepository;
import ir.verjik.repository.AccountingPeriodRepository;
import ir.verjik.repository.AccountsChartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LedgerServiceImpl implements LedgerService {

    private final AccountTransactionDetailRepository detailRepository;

    private final AccountsChartRepository accountRepository;
    private final AccountingPeriodRepository periodRepository;
    private final AccountBalanceRepository balanceRepository;

    @Override
    public AccountLedgerDto getAccountLedger(Long accountId, Long periodId) {

        AccountingChart account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        AccountingPeriod period = periodRepository.findById(periodId)
                .orElseThrow(() -> new RuntimeException("Period not found"));

        // 1. OpeningBalance
        BigDecimal opening = balanceRepository
                .findByAccountAndPeriod(account, period)
                .map(AccountBalance::getOpeningBalance)
                .orElse(BigDecimal.ZERO);

        // 2. Fetch details
        List<AccountTransactionDetail> details =
                detailRepository.findPostedByAccountAndPeriod(accountId, periodId);

        BigDecimal running = opening;
        List<LedgerEntryDto> entries = new ArrayList<>();

        for (AccountTransactionDetail d : details) {

            BigDecimal debit = d.getDebitCreditType()== DebitCreditType.DEBIT ? d.getAmountFunctional() : BigDecimal.ZERO;
            BigDecimal credit = d.getDebitCreditType()== DebitCreditType.CREDIT ? d.getAmountFunctional() : BigDecimal.ZERO;

            running = running.add(debit).subtract(credit);

            LedgerEntryDto entry = new LedgerEntryDto();
            entry.setDate(d.getAccountingTransaction().getTransactionDate());
            entry.setTransactionNumber(d.getAccountingTransaction().getTransactionNumber());
            entry.setDescription(d.getAccountingTransaction().getDescription());
            entry.setDebit(debit);
            entry.setCredit(credit);
            entry.setBalance(running);

            entries.add(entry);
        }

        AccountLedgerDto dto = new AccountLedgerDto();
        dto.setAccount(maptoAccountsChartDto(account));
        dto.setOpeningBalance(opening);
        dto.setClosingBalance(running);
        dto.setEntries(entries);

        return dto;
    }

    private AccountsChartDto maptoAccountsChartDto(AccountingChart accountingChart) {
        AccountsChartDto chartDto = new AccountsChartDto();
        chartDto.setAccountCode(accountingChart.getAccountCode());
        chartDto.setAccountType(accountingChart.getAccountType());
        chartDto.setColor(accountingChart.getColor());
        chartDto.setName(accountingChart.getName());
        chartDto.setDescription(accountingChart.getDescription());
        return chartDto;
    }

    @Override
    public GeneralLedgerDto getGeneralLedger(Long periodId) {

        AccountingPeriod period = periodRepository.findById(periodId)
                .orElseThrow(() -> new RuntimeException("Period not found"));

        List<AccountTransactionDetail> details =
                detailRepository.findGeneralLedgerForPeriod(periodId);

        Map<AccountingChart, List<AccountTransactionDetail>> grouped =
                details.stream().collect(Collectors.groupingBy(AccountTransactionDetail::getAccountingChart));

        List<GeneralLedgerAccountDto> accounts = new ArrayList<>();

        for (Map.Entry<AccountingChart, List<AccountTransactionDetail>> entry : grouped.entrySet()) {
            AccountingChart acc = entry.getKey();
            List<AccountTransactionDetail> list = entry.getValue();

            BigDecimal running = BigDecimal.ZERO;

            List<LedgerEntryDto> ledgerRows = new ArrayList<>();
            for (AccountTransactionDetail d : list) {

                BigDecimal debit = d.getDebitCreditType()== DebitCreditType.DEBIT ? d.getAmountFunctional() : BigDecimal.ZERO;
                BigDecimal credit = d.getDebitCreditType()== DebitCreditType.CREDIT ? d.getAmountFunctional() : BigDecimal.ZERO;

                running = running.add(debit).subtract(credit);

                LedgerEntryDto row = new LedgerEntryDto();
                row.setDate(d.getAccountingTransaction().getTransactionDate());
                row.setTransactionNumber(d.getAccountingTransaction().getTransactionNumber());
                row.setDescription(d.getAccountingTransaction().getDescription());
                row.setDebit(debit);
                row.setCredit(credit);
                row.setBalance(running);

                ledgerRows.add(row);
            }

            GeneralLedgerAccountDto a = new GeneralLedgerAccountDto();
            a.setAccount(maptoAccountsChartDto(acc));
            a.setEntries(ledgerRows);

            accounts.add(a);
        }

        GeneralLedgerDto dto = new GeneralLedgerDto();
        dto.setPeriod(mapToPeriodTo(period));
        dto.setAccounts(accounts);

        return dto;
    }

    private AccountingPeriodDto mapToPeriodTo(AccountingPeriod period){
        AccountingPeriodDto periodDto = new AccountingPeriodDto();
        periodDto.setPeriodNumber(period.getPeriodNumber());
        periodDto.setFromDate(period.getFromDate());
        periodDto.setToDate(period.getToDate());
        periodDto.setIsClosed(period.getIsClosed());
        return periodDto;
    }

}
