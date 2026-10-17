package ir.verjik.dto;

import java.math.BigDecimal;

public record AccountBalanceRangeDTO(
        Long accountId,
        BigDecimal opening,
        BigDecimal debit,
        BigDecimal credit,
        BigDecimal closing
) {}
