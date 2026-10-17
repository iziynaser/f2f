package ir.verjik.service;

import ir.verjik.entity.AccountTransactionDetail;
import ir.verjik.entity.AccountingTransaction;
import ir.verjik.enums.DebitCreditType;
import ir.verjik.enums.PeriodStatus;
import ir.verjik.enums.TransactionStatus;
import ir.verjik.repository.AccountingTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReverseTransactionServiceImpl implements ReverseTransactionService{

    private final AccountingTransactionRepository transactionRepository;
    private final AccountingBalanceUpdaterService balanceUpdater;
    private final NumberSequenceService sequenceService;


    public ReverseTransactionServiceImpl(
            AccountingTransactionRepository transactionRepository,
            AccountingBalanceUpdaterService balanceUpdater,
            NumberSequenceService sequenceService) {

        this.transactionRepository = transactionRepository;
        this.balanceUpdater = balanceUpdater;
        this.sequenceService = sequenceService;
    }

    public AccountingTransaction reverse(Long transactionId, String reason) {

        AccountingTransaction original =
                transactionRepository.findById(transactionId)
                        .orElseThrow(() -> new RuntimeException("Transaction not found"));

        validateReverse(original);

        AccountingTransaction reversal = createReversalTransaction(original, reason);

        List<AccountTransactionDetail> reversalDetails =
                createReversalDetails(original, reversal);

        reversal.setAccountTransactionDetails(reversalDetails);

        transactionRepository.save(reversal);

        balanceUpdater.applyBalances(reversalDetails);

        original.setTransactionStatus(TransactionStatus.REVERSED);
        original.setReversalTransaction(reversal);

        reversal.setReversedFrom(original);

        return reversal;
    }

    private void validateReverse(AccountingTransaction tx) {

        if (tx.getTransactionStatus() != TransactionStatus.POSTED) {
            throw new RuntimeException("Only POSTED transactions can be reversed");
        }

        if (tx.getReversalTransaction() != null) {
            throw new RuntimeException("Transaction already reversed");
        }

        if (tx.getAccountingPeriod().getIsClosed() != PeriodStatus.OPENED) {
            throw new RuntimeException("Cannot reverse transaction in closed period");
        }
    }

    private AccountingTransaction createReversalTransaction(
            AccountingTransaction original,
            String reason) {

        AccountingTransaction tx = new AccountingTransaction();

        //tx.setCompany(original.getCompany());
        //tx.setBranch(original.getBranch());
        tx.setAccountingPeriod(original.getAccountingPeriod());

        tx.setTransactionDate(LocalDate.now());
        tx.setTransactionStatus(TransactionStatus.POSTED);

        tx.setDescription(
                "REVERSAL OF " + original.getTransactionNumber() +
                        (reason != null ? " | " + reason : "")
        );

        String key = "TX-" +
                //original.getCompany().getId() + "-" +
                //original.getBranch().getId() + "-" +
                original.getAccountingPeriod().getId();

        Long seq = sequenceService.next(key);

        tx.setTransactionNumber(String.format("%08d", seq));

        return tx;
    }

    private List<AccountTransactionDetail> createReversalDetails(
            AccountingTransaction original,
            AccountingTransaction reversal) {

        List<AccountTransactionDetail> list = new ArrayList<>();

        for (AccountTransactionDetail d : original.getAccountTransactionDetails()) {

            AccountTransactionDetail nd = new AccountTransactionDetail();

            nd.setAccountingTransaction(reversal);

            nd.setAccountingChart(d.getAccountingChart());
            nd.setAccountingCurrency(d.getAccountingCurrency());
            nd.setExchangeRate(d.getExchangeRate());
            nd.setFloatingDetail(d.getFloatingDetail());

            nd.setSequenceId(d.getSequenceId());

            nd.setAmountFunctional(d.getAmountFunctional());
            nd.setAmountFunctional(d.getAmountFunctional());

            nd.setDebitCreditType(
                    d.getDebitCreditType() == DebitCreditType.DEBIT
                            ? DebitCreditType.CREDIT
                            : DebitCreditType.DEBIT
            );

            list.add(nd);
        }

        return list;
    }
}
