package ir.verjik.repository;


import ir.verjik.dto.*;
import ir.verjik.entity.AccountingTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AccountingTransactionCustomRepository {

    Page<TransactionSummaryDTO> search(TransactionSearchFilter filter, Pageable pageable);

    TransactionDTO findDetailedById(Long id);

    List<AccountingTransaction> findJournal(JournalFilter filter);

    List<JournalEntryDTO> findJournalEntries(JournalFilter filter);

    Optional<BigDecimal> sumBalanceBefore(Long accountId, LocalDate beforeDate);
    Optional<BigDecimal> sumDebitBetween(Long accountId, LocalDate from, LocalDate to);


}
