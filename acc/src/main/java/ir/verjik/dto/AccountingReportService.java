package ir.verjik.dto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AccountingReportService {
//
//    private final AccountTransactionDetailRepository repo;
//    private final AccountBalanceRepository balanceRepo;
//
//    public AccountingReportService(
//            AccountTransactionDetailRepository repo,
//            AccountBalanceRepository balanceRepo) {
//
//        this.repo = repo;
//        this.balanceRepo = balanceRepo;
//    }
//
//    public GeneralLedgerReport getGeneralLedger(LedgerFilter filter) {
//
//        List<AccountTransactionDetail> details = repo.findLedgerLines(filter);
//
//        if (details.isEmpty())
//            return new GeneralLedgerReport();
//
//        AccountsChart account = details.get(0).getAccountsChart();
//
//        BigDecimal opening = getOpeningBalance(account.getId(), filter);
//
//        List<GeneralLedgerLine> lines = new ArrayList<>();
//        BigDecimal bal = opening;
//
//        for (AccountTransactionDetail d : details) {
//            AccountingTransaction t = d.getAccountingTransaction();
//
//            BigDecimal amount = d.getAmountFunctional();
//
//            if (d.getDebitCreditType() == DebitCreditType.DEBIT) {
//                bal = bal.add(amount);
//                lines.add(new GeneralLedgerLine(
//                        t.getTransactionDate(),
//                        t.getTransactionNumber(),
//                        t.getDescription(),
//                        amount,
//                        BigDecimal.ZERO,
//                        bal
//                ));
//            } else {
//                bal = bal.subtract(amount);
//                lines.add(new GeneralLedgerLine(
//                        t.getTransactionDate(),
//                        t.getTransactionNumber(),
//                        t.getDescription(),
//                        BigDecimal.ZERO,
//                        amount,
//                        bal
//                ));
//            }
//        }
//
//        GeneralLedgerReport output = new GeneralLedgerReport();
//        output.setAccount(account);
//        output.setOpeningBalance(opening);
//        output.setClosingBalance(bal);
//        output.setLines(lines);
//
//        return output;
//    }
//
//    private BigDecimal getOpeningBalance(Long accountId, LedgerFilter filter) {
//        if (filter.getFromDate() == null)
//            return BigDecimal.ZERO;
//
//        return balanceRepo.findOpeningBalance(accountId, filter.getFromDate())
//                .orElse(BigDecimal.ZERO);
//    }
}
