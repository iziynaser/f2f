package com.f2f.service;

import com.f2f.dto.CreateTransactionRequest;
import com.f2f.dto.TransactionItemRequest;
import com.f2f.entity.AccountTransactionDetail;
import com.f2f.entity.AccountingTransaction;
import com.f2f.entity.AccountsChart;
import com.f2f.enums.DebitCreditType;
import com.f2f.enums.TransactionStatus;
import com.f2f.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionFactoryService {

    private final AccountRepository accountRepository;

    public TransactionFactoryService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountingTransaction createTransaction(String transNumber,
            CreateTransactionRequest dto
    ) {

        AccountingTransaction tx = new AccountingTransaction();

        tx.setTransactionNumber(transNumber);
        tx.setTransactionDate(dto.transactionDate);
        tx.setDescription(dto.description);
        tx.setTransactionStatus(TransactionStatus.DRAFT);

        return tx;
    }

    public AccountingTransaction createDraft(CreateTransactionRequest request, Long userId) {
        AccountingTransaction transaction = new AccountingTransaction();
        transaction.setTransactionStatus(TransactionStatus.DRAFT); // Set status to DRAFT
        List<AccountTransactionDetail> details = new ArrayList<>();
        List<TransactionItemRequest> items = request.getItems() ;
        for (int i = 0; i < items.size(); i++) {
            TransactionItemRequest item = items.get(i);
            AccountTransactionDetail detail = new AccountTransactionDetail();

            AccountsChart account = accountRepository.findById(item.getAccountId())
                    .orElseThrow(() -> new IllegalArgumentException("Account not found: " + item.getAccountId()));

            detail.setAccountsChart(account);

            BigDecimal amount = BigDecimal.ZERO;
            if(item.getDebit() != null) {
                detail.setAmountFunctional(item.getDebit());
                detail.setDebitCreditType(DebitCreditType.DEBIT); // DEBIT or CREDIT
            }else if(item.getCredit() != null) {
                detail.setAmountFunctional(item.getCredit());
                detail.setDebitCreditType(DebitCreditType.CREDIT); // DEBIT or CREDIT
            }

            detail.setAccountingTransaction(transaction); // Link detail to transaction

            details.add(detail);
        }
        transaction.setPostedBy(userId);
        transaction.setApprovedBy(userId);

        transaction.setAccountTransactionDetails(details);
        return transaction;
    }

}
