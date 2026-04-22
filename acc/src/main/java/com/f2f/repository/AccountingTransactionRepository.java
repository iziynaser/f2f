package com.f2f.repository;


import com.f2f.entity.AccountingPeriod;
import com.f2f.entity.AccountingTransaction;
import com.f2f.enums.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountingTransactionRepository extends JpaRepository<AccountingTransaction, Long> {

    long countByAccountingPeriod(AccountingPeriod period);

    List<AccountingTransaction> findByAccountingPeriod(AccountingPeriod period);

    List<AccountingTransaction> findByAccountingPeriodAndTransactionStatus(
            AccountingPeriod period,
            TransactionStatus status);

    @Query("""
        select max(t.transactionNumber)
        from AccountingTransaction t
        where t.accountingPeriod.id = :periodId
          and t.sourceModule = :module
    """)
    String findLastTransactionNumber(Long periodId, String module);

    List<AccountingTransaction> findBySourceModuleAndSourceId(String module, Long sourceId);

    boolean existsByAccountingPeriodAndTransactionStatus(AccountingPeriod period, TransactionStatus transactionStatus);
}

