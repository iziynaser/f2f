package ir.verjik.dto;

import java.math.BigDecimal;

public record TransactionDetailDTO(
        Long id,
        String accountId,
        String accountCode,
        String accountTitle,
        BigDecimal debit,
        BigDecimal credit
) {}
