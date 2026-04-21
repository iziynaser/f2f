package com.f2f.service;

import com.f2f.dto.CreateTransactionRequest;
import com.f2f.entity.AccountingTransaction;
import com.f2f.enums.TransactionStatus;
import com.f2f.repository.AccountingTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AccountingTransactionService {

    private final TransactionNumberGeneratorService numberGenerator;
    private final TransactionFactoryService factoryService;
    private final TransactionLifecycleManagerService lifecycleService;
    private final AccountingTransactionRepository txRepo;

    public AccountingTransactionService(
            TransactionNumberGeneratorService numberGenerator,
            TransactionFactoryService factoryService,
            TransactionLifecycleManagerService lifecycleService,
            AccountingTransactionRepository txRepo) {
        this.numberGenerator = numberGenerator;
        this.factoryService = factoryService;
        this.lifecycleService = lifecycleService;
        this.txRepo = txRepo;
    }

    public AccountingTransaction createTransaction(CreateTransactionRequest req) {

        AccountingTransaction tx =
                factoryService.createDraft(req, numberGenerator.generate());

        return txRepo.save(tx);
    }

    public AccountingTransaction post(Long id) {

        AccountingTransaction tx = txRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        lifecycleService.changeStatus(tx, TransactionStatus.POSTED);

        return txRepo.save(tx);
    }

    public AccountingTransaction lock(Long id) {

        AccountingTransaction tx = txRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        lifecycleService.changeStatus(tx, TransactionStatus.LOCKED);

        return txRepo.save(tx);
    }


    public AccountingTransaction cancel(Long id) {

        AccountingTransaction tx = txRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        lifecycleService.changeStatus(tx, TransactionStatus.CANCELLED);

        return txRepo.save(tx);
    }

    public AccountingTransaction reverse(Long id) {

        AccountingTransaction tx = txRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        lifecycleService.changeStatus(tx, TransactionStatus.REVERSED);

        return txRepo.save(tx);
    }
}
