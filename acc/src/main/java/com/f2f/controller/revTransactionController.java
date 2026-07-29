package com.f2f.controller;

import com.f2f.dto.ReverseTransactionRequest;
import com.f2f.entity.AccountingTransaction;
import com.f2f.service.ReverseTransactionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounting/transactions")
public class revTransactionController {

    private final ReverseTransactionService reverseService;

    public revTransactionController(
            ReverseTransactionService reverseService) {
        this.reverseService = reverseService;
    }

    @PostMapping("/{id}/reverse")
    public AccountingTransaction reverseTransaction(
            @PathVariable Long id,
            @RequestBody ReverseTransactionRequest request) {

        return reverseService.reverse(id, request.getReason());
    }
}
