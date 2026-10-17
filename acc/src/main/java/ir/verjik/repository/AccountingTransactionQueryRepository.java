package ir.verjik.repository;

import ir.verjik.dto.TransactionDTO;
import ir.verjik.dto.TransactionSearchFilter;
import ir.verjik.dto.TransactionSummaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountingTransactionQueryRepository {

    Page<TransactionSummaryDTO> search(TransactionSearchFilter filter, Pageable pageable);

    TransactionDTO findDetailedById(Long id);
}
