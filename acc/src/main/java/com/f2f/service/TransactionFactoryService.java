package com.f2f.service;

import com.f2f.dto.TransactionItemRequest;
import com.f2f.dto.chartOfAccount.CreateTransactionRequest;
import com.f2f.dto.transactions.AccountingTransactionResponseDto;
import com.f2f.entity.AccountTransactionDetail;
import com.f2f.entity.AccountingChart;
import com.f2f.entity.AccountingTransaction;
import com.f2f.enums.DebitCreditType;
import com.f2f.enums.TransactionStatus;
import com.f2f.mapper.AccountingTransactionMapper;
import com.f2f.repository.AccountsChartRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionFactoryService {

    private final AccountsChartRepository accountRepository;
    private final AccountingTransactionMapper transactionMapper ;

    public TransactionFactoryService(AccountsChartRepository accountRepository, AccountingTransactionMapper transactionMapper) {
        this.accountRepository = accountRepository;
        this.transactionMapper = transactionMapper;
    }

    public AccountingTransaction createTransaction(String transNumber,
            CreateTransactionRequest dto
    ) {

        AccountingTransaction tx = new AccountingTransaction();

        tx.setTransactionNumber(transNumber);
        tx.setTransactionDate(dto.getTransactionDate());
        tx.setDescription(dto.getDescription());
        tx.setTransactionStatus(TransactionStatus.DRAFT);

        return tx;
    }

    public AccountingTransactionResponseDto createDraft(CreateTransactionRequest request, Long userId) {
        AccountingTransaction transaction = new AccountingTransaction();
        transaction.setTransactionStatus(TransactionStatus.DRAFT); // Set status to DRAFT
        List<AccountTransactionDetail> details = new ArrayList<>();
        List<TransactionItemRequest> items = request.getItems() ;
        for (int i = 0; i < items.size(); i++) {
            TransactionItemRequest item = items.get(i);
            AccountTransactionDetail detail = new AccountTransactionDetail();

            AccountingChart account = accountRepository.findById(item.getAccountId())
                    .orElseThrow(() -> new IllegalArgumentException("Account not found: " + item.getAccountId()));

            detail.setAccountingChart(account);

            BigDecimal amount = BigDecimal.ZERO;

            if(item.getDebit() != null && item.getCredit() != null)
                throw new IllegalArgumentException("Both debit and credit provided");

            if(item.getDebit() == null && item.getCredit() == null)
                throw new IllegalArgumentException("Amount missing");

            if(item.getDebit() != null) {
                detail.setAmountFunctional(item.getDebit());
                detail.setDebitCreditType(DebitCreditType.DEBIT); // DEBIT or CREDIT
            }
            if(item.getCredit() != null) {
                detail.setAmountFunctional(item.getCredit());
                detail.setDebitCreditType(DebitCreditType.CREDIT); // DEBIT or CREDIT
            }

            detail.setAccountingTransaction(transaction); // Link detail to transaction
            detail.setSequenceId(i+1);
            details.add(detail);
        }
        transaction.setPostedBy(userId);
        transaction.setApprovedBy(userId);
        transaction.setTransactionDate(request.getTransactionDate()!=null ? request.getTransactionDate() : LocalDate.now());
        transaction.setAccountTransactionDetails(details);
        return transactionMapper.toDto(transaction);

    }

}
