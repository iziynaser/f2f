package com.f2f.service;

import com.f2f.entity.AccountTransactionDetail;
import com.f2f.entity.AccountingTransaction;
import com.f2f.enums.DebitCreditType;
import com.f2f.enums.PeriodStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionValidationService {

    public void validate(AccountingTransaction  dto) {

        if (dto.getAccountTransactionDetails() == null || dto.getAccountTransactionDetails().size() < 2)
            throw new RuntimeException("Transaction must have at least two items");

        BigDecimal debitTotal = BigDecimal.ZERO;
        BigDecimal creditTotal = BigDecimal.ZERO;

        if (dto.getAccountingPeriod() == null ||
                dto.getAccountingPeriod().getIsClosed() != PeriodStatus.OPENED)
            throw new RuntimeException("Accounting period must be opened");


        for (AccountTransactionDetail item : dto.getAccountTransactionDetails()) {

            if(item.getAccountingChart()==null)
                throw new RuntimeException("Account chart is null");

            //بررسی مقدار منفی
            if(item.getAmountFunctional()==null || item.getAmountFunctional().compareTo(BigDecimal.ZERO) <= 0)
                throw new RuntimeException("Amount functional must be greater than zero");

            // حساب باید postable باشد
            if (!Boolean.TRUE.equals(item.getAccountingChart().getPostable()))
                throw new RuntimeException("Account chart must have postable");

            if(item.getDebitCreditType()==null)
                throw new RuntimeException("Debit credit type is null");

            BigDecimal debit = item.getDebitCreditType()==DebitCreditType.DEBIT ? item.getAmountFunctional() : BigDecimal.ZERO;
            BigDecimal credit = item.getDebitCreditType()==DebitCreditType.CREDIT ? item.getAmountFunctional() : BigDecimal.ZERO;

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
