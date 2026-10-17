package ir.verjik.service;

import ir.verjik.entity.AccountingTransaction;
import ir.verjik.entity.AccountingTransactionLog;
import ir.verjik.enums.TransactionStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionLifecycleManagerService {

    private final TransactionValidationService validationService;
    private final AccountingBalanceUpdaterService balanceUpdaterService;

    public TransactionLifecycleManagerService(
            TransactionValidationService validationService,
            AccountingBalanceUpdaterService balanceUpdaterService) {
        this.validationService = validationService;
        this.balanceUpdaterService = balanceUpdaterService;
    }


    public void changeStatus(AccountingTransaction tx, TransactionStatus targetStatus) {

        validateTransition(tx.getTransactionStatus(), targetStatus);

        switch (targetStatus) {

            case POSTED:
                post(tx);
                break;

            case LOCKED:
                lock(tx);
                break;

            case CANCELLED:
                cancel(tx);
                break;

            case REVERSED:
                throw new UnsupportedOperationException("use reverse transaction service");
                //reverse(tx);
                //break;

            default:
                throw new IllegalArgumentException("Unsupported target status: " + targetStatus);
        }

        tx.setTransactionStatus(targetStatus);
    }


    public void validateTransition(TransactionStatus current, TransactionStatus target) {

        switch (current) {

            case DRAFT:
                if (target == TransactionStatus.POSTED ||
                        target == TransactionStatus.CANCELLED)
                    return;
                break;

            case POSTED:
                if (target == TransactionStatus.LOCKED ||
                        target == TransactionStatus.REVERSED)
                    return;
                break;

            case LOCKED:
                break;

            case REVERSED:
                break;

            case CANCELLED:
                break;
        }

        throw new IllegalStateException(
                "Invalid transaction status transition: " + current + " → " + target
        );
    }

    private void post(AccountingTransaction tx) {

        if(!tx.getTransactionStatus().equals(TransactionStatus.DRAFT))
            throw new IllegalArgumentException("Invalid transaction status: " + tx.getTransactionStatus());

        validationService.validate(tx);
        balanceUpdaterService.applyBalances(tx.getAccountTransactionDetails());

        addLog(tx, "POSTED");
    }

    private void lock(AccountingTransaction tx) {
        addLog(tx, "LOCKED");
    }

    private void cancel(AccountingTransaction tx) {

        if (tx.getTransactionStatus() != TransactionStatus.DRAFT)
            throw new IllegalStateException("Only DRAFT transactions can be cancelled.");

        addLog(tx, "CANCELLED");
    }

    private void addLog(AccountingTransaction tx, String action) {
        AccountingTransactionLog log = new AccountingTransactionLog();
        //log.setAction(action);
        log.setTransaction(tx);
        log.setLogDate(LocalDateTime.now());
        tx.getLogs().add(log);
    }
}
