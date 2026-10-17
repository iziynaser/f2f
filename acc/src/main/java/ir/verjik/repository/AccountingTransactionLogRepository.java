package ir.verjik.repository;

import ir.verjik.entity.AccountingTransactionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountingTransactionLogRepository extends JpaRepository<AccountingTransactionLog, Long> {
}
