package ir.verjik.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public record BalanceRowDTO(
        Long accountId,
        String code,
        String title,
        BigDecimal opening,
        BigDecimal debit,
        BigDecimal credit,
        BigDecimal closing,
        BigDecimal debitClosing,
        BigDecimal creditClosing
) {}
