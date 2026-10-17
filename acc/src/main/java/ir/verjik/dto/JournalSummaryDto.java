package ir.verjik.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record JournalSummaryDto(
        LocalDate date,
        String voucherNumber,
        String description,
        BigDecimal debit,
        BigDecimal credit
) {}
