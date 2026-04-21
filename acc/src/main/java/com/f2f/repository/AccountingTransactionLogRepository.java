package com.f2f.repository;

import com.f2f.entity.AccountingTransactionLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountingTransactionLogRepository extends JpaRepository<AccountingTransactionLog, Long> {
}
