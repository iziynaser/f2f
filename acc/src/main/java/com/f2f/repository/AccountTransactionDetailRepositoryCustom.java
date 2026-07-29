package com.f2f.repository;

import com.f2f.entity.AccountTransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import java.util.Optional;
public interface AccountTransactionDetailRepositoryCustom {
    Optional<BigDecimal> sumDebitInDateRange(Long accountId, LocalDate from, LocalDate to);
    Optional<BigDecimal> sumCreditInDateRange(Long accountId, LocalDate from, LocalDate to);
    Optional<BigDecimal> sumOpeningBefore(Long accountId, LocalDate beforeDate);

    List<AccountTransactionDetail> findPostedByAccountAndPeriod(Long accountId, Long periodId);

    List<AccountTransactionDetail> findGeneralLedgerForPeriod(Long periodId);

    List<AccountTransactionDetail> findAllPostedForTrialBalance(Long periodId);

    Optional<BigDecimal> sumCreditBetween(Long accountId, LocalDate from, LocalDate to);
}
