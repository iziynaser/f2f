package ir.verjik.repository;


import ir.verjik.dto.JournalEntryDTO;

import java.time.LocalDate;
import java.util.List;

public interface JournalReportRepository {

    List<JournalEntryDTO> getJournal(LocalDate from, LocalDate to);

    List<JournalEntryDTO> getJournalByPeriod(Long periodId);

    List<JournalEntryDTO> getJournalByTransactionId(Long transactionId);
}
