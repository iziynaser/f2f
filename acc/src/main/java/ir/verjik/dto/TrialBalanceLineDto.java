package ir.verjik.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TrialBalanceLineDto {
    private String accountCode;
    private String accountName;
    private BigDecimal debitTotal;
    private BigDecimal creditTotal;
    private BigDecimal netBalance;
}

