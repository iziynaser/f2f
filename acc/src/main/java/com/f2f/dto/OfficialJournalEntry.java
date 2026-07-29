package com.f2f.dto;

import java.time.LocalDate;
import java.util.List;

public record OfficialJournalEntry(
        String voucher,
        LocalDate date,
        String description,
        List<OfficialJournalDetail> details
) {}
