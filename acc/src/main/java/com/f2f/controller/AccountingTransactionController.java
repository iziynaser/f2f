package com.f2f.controller;

import com.f2f.dto.JournalEntryDTO;
import com.f2f.dto.JournalFilter;
import com.f2f.dto.TransactionSearchFilter;
import com.f2f.dto.TransactionSummaryDTO;
import com.f2f.dto.chartOfAccount.CreateTransactionRequest;
import com.f2f.dto.transactions.AccountingTransactionResponseDto;
import com.f2f.entity.AccountingTransaction;
import com.f2f.service.AccountingTransactionService;
import com.f2f.service.ReverseTransactionService;
import com.f2f.service.TransactionQueryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
همه درخواست های مربوط به ایجاد ، ویرایش ، نهایی سازی ، ابطال و بازیابی اسناد حسابداری
از اینجا عبور می کنند
 */
@RestController
@RequestMapping("/transactions")
public class AccountingTransactionController {

    private final AccountingTransactionService txService;
    private final ReverseTransactionService reverseService;
    private final TransactionQueryService queryService;

    public AccountingTransactionController(AccountingTransactionService txService,
                                           ReverseTransactionService reverseService,
                                           TransactionQueryService queryService) {
        this.txService = txService;
        this.reverseService = reverseService;
        this.queryService = queryService;
    }

    // ایجاد پیش‌نویس جدید
    @PostMapping
    public ResponseEntity<AccountingTransactionResponseDto> create(@RequestBody CreateTransactionRequest req) {
        return ResponseEntity.ok(txService.createTransaction(req));
    }

    // ثبت نهایی سند (قطعی کردن)
    @PostMapping("/{id}/post")
    public ResponseEntity<AccountingTransaction> post(@PathVariable Long id) {
        return ResponseEntity.ok(txService.post(id));
    }

    // قفل کردن سند
    @PostMapping("/{id}/lock")
    public ResponseEntity<AccountingTransaction> lock(@PathVariable Long id) {
        return ResponseEntity.ok(txService.lock(id));
    }

    // لغو سند (فقط در حالت Draft)
    @PostMapping("/{id}/cancel")
    public ResponseEntity<AccountingTransaction> cancel(@PathVariable Long id) {
        return ResponseEntity.ok(txService.cancel(id));
    }

    // برگشت سند (Reverse)
    @PostMapping("/{id}/reverse")
    public ResponseEntity<AccountingTransaction> reverse(@PathVariable Long id, @RequestParam(required = false) String reason) {
        return ResponseEntity.ok(reverseService.reverse(id, reason));
    }

    @GetMapping
    public ResponseEntity<Page<TransactionSummaryDTO>> search(
        @RequestBody TransactionSearchFilter filter,
        Pageable pageable) {

    Page<TransactionSummaryDTO> page = queryService.search(filter, pageable);
    return ResponseEntity.ok(page);
}

    @GetMapping("/{id}")
    public ResponseEntity<AccountingTransaction> getById(@PathVariable Long id) {
        Optional<AccountingTransaction> t = txService.getById(id);
        if(t.isPresent()) {
            return ResponseEntity.ok(t.orElse(null));
        }
        return null;
    }
    @PutMapping("/{id}")
    public ResponseEntity<AccountingTransaction> update(
            @PathVariable Long id,
            @RequestBody CreateTransactionRequest req
    ) {
        return ResponseEntity.ok(txService.update(id, req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        txService.delete(id);

        return ResponseEntity.noContent().build();
    }


    @GetMapping("/journal")
    public List<JournalEntryDTO> journal(JournalFilter filter) {

        return txService.getJournal(filter);
    }
}
