package com.f2f.dto;

import java.math.BigDecimal;

public record OfficialJournalDetail(
        String accountCode,
        String accountTitle,
        BigDecimal debit,
        BigDecimal credit
) {}

