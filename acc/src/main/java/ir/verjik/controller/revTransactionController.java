package ir.verjik.controller;

import ir.verjik.dto.ReverseTransactionRequest;
import ir.verjik.entity.AccountingTransaction;
import ir.verjik.service.ReverseTransactionService;
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
