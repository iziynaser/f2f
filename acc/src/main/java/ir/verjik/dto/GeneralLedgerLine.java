package ir.verjik.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record GeneralLedgerLine(
        LocalDate date,
        String voucher,
        String description,
        BigDecimal debit,
        BigDecimal credit,
        BigDecimal runningBalance
) {}