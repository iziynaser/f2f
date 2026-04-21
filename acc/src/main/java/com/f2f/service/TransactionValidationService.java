package com.f2f.service;

import com.f2f.dto.CreateTransactionRequest;
import com.f2f.dto.TransactionItemRequest;
import com.f2f.entity.AccountTransactionDetail;
import com.f2f.entity.AccountingTransaction;
import com.f2f.enums.DebitCreditType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionValidationService {

    public void validate(AccountingTransaction  dto) {

        if (dto.getAccountTransactionDetails() == null || dto.getAccountTransactionDetails().size() < 2)
            throw new RuntimeException("Transaction must have at least two items");

        BigDecimal debitTotal = BigDecimal.ZERO;
        BigDecimal creditTotal = BigDecimal.ZERO;

        for (AccountTransactionDetail item : dto.getAccountTransactionDetails()) {

            BigDecimal debit = DebitCreditType.DEBIT.compareTo(item.getDebitCreditType())==0 ? BigDecimal.ZERO : item.getAmountFunctional();
            BigDecimal credit = DebitCreditType.CREDIT.compareTo(item.getDebitCreditType())==0 ? BigDecimal.ZERO : item.getAmountFunctional();

            if (debit.compareTo(BigDecimal.ZERO) > 0 &&
                    credit.compareTo(BigDecimal.ZERO) > 0) {

                throw new RuntimeException("Item cannot have both debit and credit");
            }

            debitTotal = debitTotal.add(debit);
            creditTotal = creditTotal.add(credit);
        }

        if (debitTotal.compareTo(creditTotal) != 0)
            throw new RuntimeException("Transaction is not balanced");
    }
}
