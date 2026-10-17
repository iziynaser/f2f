package ir.verjik.service;

import ir.verjik.dto.TransactionDTO;
import ir.verjik.dto.TransactionSearchFilter;
import ir.verjik.dto.TransactionSummaryDTO;
import ir.verjik.repository.AccountingTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
@Transactional(readOnly = true)
public class TransactionQueryService {

    private final AccountingTransactionRepository trRepo;

    public TransactionQueryService(AccountingTransactionRepository trRepo) {
        this.trRepo = trRepo;
    }

    /**
     * جستجوی پیشرفته اسناد حسابداری
     * شامل:
     *   - شماره سند
     *   - بازه تاریخ
     *   - بازه مبلغ
     *   - وضعیت
     *   - شناسه حساب
     *   - شناسه دوره
     * و خروجی کاملاً صفحه‌بندی‌شده
     */
    public Page<TransactionSummaryDTO> search(TransactionSearchFilter filter, Pageable pageable) {
        return trRepo.search(filter, pageable);
    }

    /**
     * دریافت سند کامل به همراه تمام ردیف‌های آن
     */
    public TransactionDTO getTransaction(Long id) {
        TransactionDTO dto = trRepo.findDetailedById(id);
        if (dto == null)
            throw new RuntimeException("Transaction not found: " + id);
        return dto;
    }
}
