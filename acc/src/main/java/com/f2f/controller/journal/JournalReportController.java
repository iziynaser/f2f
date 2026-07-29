package com.f2f.controller.journal;

import com.f2f.dto.AccountJournalDto;
import com.f2f.dto.JournalFilter;
import com.f2f.dto.JournalSummaryDto;
import com.f2f.entity.AccountingTransaction;
import com.f2f.service.JournalReportService;
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
