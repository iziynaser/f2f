package com.f2f.service;

import com.f2f.dto.AccountJournalDto;
import com.f2f.dto.JournalFilter;
import com.f2f.dto.JournalSummaryDto;
import com.f2f.entity.AccountingTransaction;

import java.util.List;

public interface JournalReportService {

    List<AccountingTransaction> getJournal(JournalFilter filter);

    List<JournalSummaryDto> getJournalSummary(JournalFilter filter);

    AccountJournalDto getAccountJournal(Long accountId, JournalFilter filter);
}
