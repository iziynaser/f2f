package ir.verjik.dto;



import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * DTO مانده حساب
 * خروجی مناسب برای تراز آزمایشی، گزارش مانده و دفتر کل
 */

@Setter
@Getter
public class AccountBalanceDTO {
    Long accountId;
    String accountCode;
    String accountTitle;

    BigDecimal openingDebit;
    BigDecimal openingCredit;

    BigDecimal periodDebit;
    BigDecimal periodCredit;

    BigDecimal closingDebit;
    BigDecimal closingCredit;

    public AccountBalanceDTO() {}
    public AccountBalanceDTO(Long id, String accountCode, String name, BigDecimal openingBalance,
                             BigDecimal debitTotal, BigDecimal creditTotal, BigDecimal closingBalance){
        this.accountId = id;
        this.accountCode = accountCode;
        this.accountTitle = name;
        this.openingDebit = openingBalance;
        this.openingCredit = debitTotal;
        this.periodDebit = creditTotal;
        this.closingCredit = closingBalance;

    }
    public BigDecimal openingBalance() {
        return openingDebit.subtract(openingCredit);
    }

    /**
     * مانده خالص گردش دوره
     */
    public BigDecimal periodNet() {
        return periodDebit.subtract(periodCredit);
    }

    /**
     * مانده خالص پایان دوره
     */
    public BigDecimal closingBalance() {
        return closingDebit.subtract(closingCredit);
    }

    public boolean isClosingDebit() {
        return closingDebit.compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean isClosingCredit() {
        return closingCredit.compareTo(BigDecimal.ZERO) > 0;
    }

}
