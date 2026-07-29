package com.f2f.repository;


import com.f2f.dto.JournalEntryDTO;

import java.time.LocalDate;
import java.util.List;

public interface JournalReportRepository {

    List<JournalEntryDTO> getJournal(LocalDate from, LocalDate to);

    List<JournalEntryDTO> getJournalByPeriod(Long periodId);

    List<JournalEntryDTO> getJournalByTransactionId(Long transactionId);
}
