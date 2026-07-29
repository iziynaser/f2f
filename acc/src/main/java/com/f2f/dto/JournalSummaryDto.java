package com.f2f.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record JournalSummaryDto(
        LocalDate date,
        String voucherNumber,
        String description,
        BigDecimal debit,
        BigDecimal credit
) {}
