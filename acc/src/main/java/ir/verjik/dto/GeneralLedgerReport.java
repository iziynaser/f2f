package ir.verjik.dto;

import ir.verjik.entity.AccountingChart;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
public class GeneralLedgerReport {
    private AccountingChart account;
    private BigDecimal openingBalance;
    private BigDecimal closingBalance;
    private List<GeneralLedgerLine> lines;
}