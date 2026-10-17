package ir.verjik.dto;

import ir.verjik.enums.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionSummaryDTO(
        Long id,
        Long number,
        LocalDate date,
        String description,
        TransactionStatus status,
        BigDecimal totalDebit,
        BigDecimal totalCredit
) {}
