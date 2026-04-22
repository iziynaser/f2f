package com.f2f.repository;


import com.f2f.entity.AccountTransactionDetail;
import com.f2f.entity.AccountingTransaction;
import com.f2f.entity.AccountsChart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface AccountTransactionDetailRepository extends JpaRepository<AccountTransactionDetail, Long> {
    @Query("""
       select td 
       from AccountTransactionDetail td 
       join fetch td.accountingTransaction t 
       where t.transactionStatus = 'POSTED'
         and td.accountsChart.id = :accountId
         and t.accountingPeriod.id = :periodId
       order by t.transactionDate, t.id
    """)
    List<AccountTransactionDetail> findPostedByAccountAndPeriod(Long accountId, Long periodId);


    @Query("""
       select td 
       from AccountTransactionDetail td 
       join fetch td.accountingTransaction t 
       where t.transactionStatus = 'POSTED'
         and t.accountingPeriod.id = :periodId
       order by td.accountsChart.accountCode, t.transactionDate, t.id
    """)
    List<AccountTransactionDetail> findGeneralLedgerForPeriod(Long periodId);

    @Query("""
    select td 
    from AccountTransactionDetail td 
    join fetch td.accountingTransaction t 
    where t.transactionStatus = 'POSTED'
      and t.accountingPeriod.id = :periodId
""")
    List<AccountTransactionDetail> findAllPostedForTrialBalance(Long periodId);

}
