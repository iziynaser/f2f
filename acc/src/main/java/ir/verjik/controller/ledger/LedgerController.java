package ir.verjik.controller.ledger;

import ir.verjik.dto.AccountLedgerDto;
import ir.verjik.dto.GeneralLedgerDto;
import ir.verjik.service.LedgerService;
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
