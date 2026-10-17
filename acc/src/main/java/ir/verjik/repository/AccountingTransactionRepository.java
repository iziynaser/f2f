package ir.verjik.repository;


import ir.verjik.entity.AccountingPeriod;
import ir.verjik.entity.AccountingTransaction;
import ir.verjik.enums.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AccountingTransactionRepository
        extends JpaRepository<AccountingTransaction, Long>,
        AccountingTransactionCustomRepository {

    long countByAccountingPeriod(AccountingPeriod period);

    List<AccountingTransaction> findByAccountingPeriod(AccountingPeriod period);

    List<AccountingTransaction> findByAccountingPeriodAndTransactionStatus(
            AccountingPeriod period,
            TransactionStatus status);

    List<AccountingTransaction> findBySourceModuleAndSourceId(
            String module,
            Long sourceId);

    boolean existsByAccountingPeriodAndTransactionStatus(
            AccountingPeriod period,
            TransactionStatus transactionStatus);

    Optional<BigDecimal> sumBalanceBefore(Long accountId, LocalDate beforeDate);

    Optional<BigDecimal> sumDebitBetween(Long accountId, LocalDate from, LocalDate to);

}
