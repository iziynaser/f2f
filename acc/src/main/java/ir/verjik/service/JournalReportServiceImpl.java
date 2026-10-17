package ir.verjik.service;

import ir.verjik.dto.AccountJournalDto;
import ir.verjik.dto.AccountJournalLine;
import ir.verjik.dto.JournalFilter;
import ir.verjik.dto.JournalSummaryDto;
import ir.verjik.entity.AccountTransactionDetail;
import ir.verjik.entity.AccountingChart;
import ir.verjik.entity.AccountingTransaction;
import ir.verjik.enums.DebitCreditType;
import ir.verjik.repository.AccountBalanceRepository;
import ir.verjik.repository.AccountingTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class JournalReportServiceImpl implements JournalReportService {

    private final AccountingTransactionRepository repo;
    private final AccountBalanceRepository balanceRepo;

    public JournalReportServiceImpl(AccountingTransactionRepository repo,
                                    AccountBalanceRepository balanceRepo) {
        this.repo = repo;
        this.balanceRepo = balanceRepo;
    }

    @Override
    public List<AccountingTransaction> getJournal(JournalFilter filter) {
        return repo.findJournal(filter);
    }

    @Override
    public List<JournalSummaryDto> getJournalSummary(JournalFilter filter) {

        List<AccountingTransaction> txs = repo.findJournal(filter);

        List<JournalSummaryDto> list = new ArrayList<>();

        for (AccountingTransaction t : txs) {

            BigDecimal debit = BigDecimal.ZERO;
            BigDecimal credit = BigDecimal.ZERO;

            for (AccountTransactionDetail d : t.getAccountTransactionDetails()) {
                if (d.getDebitCreditType() == DebitCreditType.DEBIT)
                    debit = debit.add(d.getAmountFunctional());
                else if(d.getDebitCreditType() == DebitCreditType.CREDIT)
                    credit = credit.add(d.getAmountFunctional());
            }

            list.add(new JournalSummaryDto(
                    t.getTransactionDate(),
                    t.getTransactionNumber(),
                    t.getDescription(),
                    debit,
                    credit
            ));
        }

        return list;
    }

    @Override
    public AccountJournalDto getAccountJournal(Long accountId, JournalFilter filter) {

        filter.setAccountId(accountId);

        List<AccountingTransaction> txs = repo.findJournal(filter);

        AccountingChart account = null;

        AccountJournalDto dto = new AccountJournalDto();
        List<AccountJournalLine> lines = new ArrayList<>();

        BigDecimal balance = getOpeningBalance(accountId, filter);

        dto.setOpeningBalance(balance);

        for (AccountingTransaction t : txs) {
            for (AccountTransactionDetail d : t.getAccountTransactionDetails()) {

                if (!d.getAccountingChart().getId().equals(accountId))
                    continue;

                account = d.getAccountingChart();

                BigDecimal amount = d.getAmountFunctional();

                if (d.getDebitCreditType() == DebitCreditType.DEBIT)
                    balance = balance.add(amount);
                else
                    balance = balance.subtract(amount);

                lines.add(new AccountJournalLine(
                        t.getTransactionDate(),
                        t.getTransactionNumber(),
                        t.getDescription(),
                        d.getDebitCreditType() == DebitCreditType.DEBIT ? amount : BigDecimal.ZERO,
                        d.getDebitCreditType() == DebitCreditType.CREDIT ? amount : BigDecimal.ZERO,
                        balance
                ));
            }
        }

        dto.setAccount(account);
        dto.setLines(lines);
        dto.setClosingBalance(balance);

        return dto;
    }

    private BigDecimal getOpeningBalance(Long accountId, JournalFilter filter) {
        if (filter.getFromDate() == null)
            return BigDecimal.ZERO;

        return balanceRepo.findOpeningBalance(accountId, filter.getFromDate())
                .orElse(BigDecimal.ZERO);
    }

}
