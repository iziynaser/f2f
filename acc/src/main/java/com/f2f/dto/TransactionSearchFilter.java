package com.f2f.dto;

import com.f2f.enums.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionSearchFilter(
        Long number,
        LocalDate from,
        LocalDate to,
        Long periodId,
        TransactionStatus status,
        Long accountId,   // فیلتر روی جزئیات
        BigDecimal minAmount,
        BigDecimal maxAmount
) {}
