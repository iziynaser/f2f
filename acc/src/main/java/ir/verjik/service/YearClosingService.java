package ir.verjik.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class YearClosingService {
//
//    private final AccountBalanceRepository balanceRepository;
//    private final AccountingTransactionRepository transactionRepository;
//    private final TransactionLifecycleManagerService lifecycleService;
//    private final NumberSequenceService sequenceService;
//    private final AccountsChartRepository accountRepository;
//
//    public YearClosingService(
//            AccountBalanceRepository balanceRepository,
//            AccountingTransactionRepository transactionRepository,
//            TransactionLifecycleManagerService lifecycleService,
//            NumberSequenceService sequenceService,
//            AccountsChartRepository accountRepository) {
//
//        this.balanceRepository = balanceRepository;
//        this.transactionRepository = transactionRepository;
//        this.lifecycleService = lifecycleService;
//        this.sequenceService = sequenceService;
//        this.accountRepository = accountRepository;
//    }
//
//    public AccountingTransaction closeYear(Long fiscalYearId) {
//
//        List<AccountBalance> balances =
//                balanceRepository.findYearBalances(fiscalYearId);
//
//        AccountsChart retainedEarnings =
//                accountRepository.findRetainedEarningsAccount()
//                        .orElseThrow(() -> new RuntimeException("Retained earnings account not configured"));
//
//        List<AccountTransactionDetail> details = new ArrayList<>();
//
//        BigDecimal profit = BigDecimal.ZERO;
//
//        for (AccountBalance bal : balances) {
//
//            AccountsChart acc = bal.getAccount();
//
//            if (acc.getAccountNature() == AccountNature.REVENUE) {
//
////                if (bal.getBalance().compareTo(BigDecimal.ZERO) != 0) {
////
////                    profit = profit.add(bal.getBalance());
////
////                    details.add(createDetail(
////                            acc,
////                            bal.getBalance(),
////                            DebitCreditType.DEBIT
////                    ));
////                }
//            }
//
//            if (acc.getAccountNature() == AccountNature.EXPENSE) {
//
//                if (bal.getBalance().compareTo(BigDecimal.ZERO) != 0) {
//
//                    profit = profit.subtract(bal.getBalance());
//
//                    details.add(createDetail(
//                            acc,
//                            bal.getBalance(),
//                            DebitCreditType.CREDIT
//                    ));
//                }
//            }
//        }
//
//        if (profit.compareTo(BigDecimal.ZERO) != 0) {
//
//            DebitCreditType type =
//                    profit.signum() > 0
//                            ? DebitCreditType.CREDIT
//                            : DebitCreditType.DEBIT;
//
//            details.add(createDetail(
//                    retainedEarnings,
//                    profit.abs(),
//                    type
//            ));
//        }
//
//        AccountingTransaction tx = buildClosingTransaction(details);
//
//        transactionRepository.save(tx);
//
//        lifecycleService.changeStatus(tx, TransactionStatus.POSTED);
//
//        return tx;
//    }
//
//    private AccountingTransaction buildClosingTransaction(List<AccountTransactionDetail> details) {
//
//        AccountingTransaction tx = new AccountingTransaction();
//
//        tx.setTransactionDate(LocalDate.now());
//        tx.setDescription("YEAR CLOSING ENTRY");
//
//        String key = "YEAR_CLOSE";
//
//        Long seq = sequenceService.next(key);
//
//        tx.setTransactionNumber("YC-" + seq);
//
//        tx.setTransactionStatus(TransactionStatus.DRAFT);
//
//        for (int i = 0; i < details.size(); i++) {
//
//            AccountTransactionDetail d = details.get(i);
//
//            d.setAccountingTransaction(tx);
//            d.setSequenceId(i + 1);
//        }
//
//        tx.setAccountTransactionDetails(details);
//
//        return tx;
//    }
//
//    private AccountTransactionDetail createDetail(
//            AccountsChart account,
//            BigDecimal amount,
//            DebitCreditType type) {
//
//        AccountTransactionDetail d = new AccountTransactionDetail();
//
//        d.setAccountsChart(account);
//        d.setAmountFunctional(amount);
//        d.setDebitCreditType(type);
//
//        return d;
//    }
}
