package com.f2f.controller.ledger;

import com.f2f.dto.AccountLedgerDto;
import com.f2f.dto.GeneralLedgerDto;
import com.f2f.service.LedgerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ledger")
@RequiredArgsConstructor
public class LedgerController {

    private final LedgerService ledgerService;

    // دفتر حساب یک حساب خاص
    @GetMapping("/account")
    public AccountLedgerDto getAccountLedger(
            @RequestParam Long accountId,
            @RequestParam Long periodId
    ) {
        return ledgerService.getAccountLedger(accountId, periodId);
    }

    // دفتر کل
    @GetMapping("/general")
    public GeneralLedgerDto getGeneralLedger(
            @RequestParam Long periodId
    ) {
        return ledgerService.getGeneralLedger(periodId);
    }
}
