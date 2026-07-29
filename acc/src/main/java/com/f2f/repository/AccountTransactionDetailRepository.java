package com.f2f.repository;

import com.f2f.entity.AccountTransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AccountTransactionDetailRepository
        extends JpaRepository<AccountTransactionDetail, Long>,
        AccountTransactionDetailRepositoryCustom {

    @Query("""
select d
from AccountTransactionDetail d
join fetch d.accountingTransaction t
where d.accountingChart.id = :accountId
and t.transactionDate between :from and :to
and t.transactionStatus = 'POSTED'
order by t.transactionDate, t.transactionNumber, d.id
""")
    List<AccountTransactionDetail> findLedgerLines(
            Long accountId,
            LocalDate from,
            LocalDate to
    );

    @Query("""
        select coalesce(sum(
            case when d.debitCreditType = 'DEBIT' then d.amountFunctional
                 else -d.amountFunctional end
        ), 0)
        from AccountTransactionDetail d
        where d.accountingChart.id = :accountId
          and d.accountingTransaction.transactionDate < :date
          and d.accountingTransaction.transactionStatus = 'POSTED'
    """)
    Optional<BigDecimal> sumMovementBeforeDate(Long accountId, LocalDate date);

    @Query("""
        select coalesce(sum(d.amountFunctional), 0)
        from AccountTransactionDetail d
        where d.accountingChart.id = :accountId
          and d.debitCreditType = 'DEBIT'
          and d.accountingTransaction.transactionDate between :from and :to
          and d.accountingTransaction.transactionStatus = 'POSTED'
    """)
    Optional<BigDecimal> sumDebitBetween(Long accountId, LocalDate from, LocalDate to);

    //
//    @Query("""
//        select coalesce(sum(d.amountFunctional), 0)
//        from AccountTransactionDetail d
//        where d.account.id = :accountId
//          and d.debitCreditType = 'CREDIT'
//          and d.accountingTransaction.transactionDate between :from and :to
//          and d.accountingTransaction.status = 'POSTED'
//    """)
//    Optional<BigDecimal> sumCreditBetween(Long accountId, LocalDate from, LocalDate to);

}

