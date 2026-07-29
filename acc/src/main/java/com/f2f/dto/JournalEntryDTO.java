package com.f2f.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record JournalEntryDTO(
        Long transactionId,
        Long transactionNumber,
        LocalDate transactionDate,
        String transactionDescription,

        Long detailId,
        Long accountId,
        String accountCode,
        String accountTitle,

        BigDecimal debit,
        BigDecimal credit
) {}
