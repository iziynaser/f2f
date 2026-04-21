package com.f2f.repository;

import com.f2f.entity.AccountTransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDetailRepository
        extends JpaRepository<AccountTransactionDetail, Long> {
}
