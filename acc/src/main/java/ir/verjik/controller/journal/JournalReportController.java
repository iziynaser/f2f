package ir.verjik.controller.journal;

import ir.verjik.dto.AccountJournalDto;
import ir.verjik.dto.JournalFilter;
import ir.verjik.dto.JournalSummaryDto;
import ir.verjik.entity.AccountingTransaction;
import ir.verjik.service.JournalReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports/journal")
@RequiredArgsConstructor
public class JournalReportController {

    private final JournalReportService journalReportService;

    @PostMapping
    public List<AccountingTransaction> getJournal(@RequestBody JournalFilter filter) {
        return journalReportService.getJournal(filter);
    }

    @PostMapping("/summary")
    public List<JournalSummaryDto> getJournalSummary(@RequestBody JournalFilter filter) {
        return journalReportService.getJournalSummary(filter);
    }

    @PostMapping("/account/{accountId}")
    public AccountJournalDto getAccountJournal(
            @PathVariable Long accountId,
            @RequestBody JournalFilter filter) {

        return journalReportService.getAccountJournal(accountId, filter);
    }
}
