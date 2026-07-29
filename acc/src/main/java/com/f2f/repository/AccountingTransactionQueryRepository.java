package com.f2f.repository;

import com.f2f.dto.TransactionDTO;
import com.f2f.dto.TransactionSearchFilter;
import com.f2f.dto.TransactionSummaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountingTransactionQueryRepository {

    Page<TransactionSummaryDTO> search(TransactionSearchFilter filter, Pageable pageable);

    TransactionDTO findDetailedById(Long id);
}
