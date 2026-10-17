package ir.verjik.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
public class SubsidiaryLedgerLine {
    private LocalDate date;
    private String transactionNumber;
    private String description;
    private String counterAccountCode;
    private String counterAccountTitle;
    private BigDecimal debit;
    private BigDecimal credit;
    private BigDecimal balance;

    public SubsidiaryLedgerLine(LocalDate transactionDate,
                    String transactionNumber,String description, String counterAccountCode,
                    BigDecimal debit,BigDecimal credit,BigDecimal balance) {
        this.date = transactionDate;
        this.transactionNumber = transactionNumber;
        this.description = description;
        this.counterAccountCode = counterAccountCode;
        this.debit = debit;
        this.credit = credit;
        this.balance = balance;
    }
}
