package com.f2f.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AccountJournalLine(
        LocalDate date,
        String voucher,
        String description,
        BigDecimal debit,
        BigDecimal credit,
        BigDecimal balance
) {}
