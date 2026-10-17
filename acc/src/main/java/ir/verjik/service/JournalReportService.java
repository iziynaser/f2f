package ir.verjik.service;

import ir.verjik.dto.AccountJournalDto;
import ir.verjik.dto.JournalFilter;
import ir.verjik.dto.JournalSummaryDto;
import ir.verjik.entity.AccountingTransaction;

import java.util.List;

public interface JournalReportService {

    List<AccountingTransaction> getJournal(JournalFilter filter);

    List<JournalSummaryDto> getJournalSummary(JournalFilter filter);

    AccountJournalDto getAccountJournal(Long accountId, JournalFilter filter);
}
