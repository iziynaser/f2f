package ir.verjik.dto.chartOfAccount;

import java.math.BigDecimal;

/*
خروجی خط سند
 */
public class TransactionLineResponse {
    private Long id;
    private Long accountId;
    private String accountCode;
    private String accountName;
    private BigDecimal debit;
    private BigDecimal credit;
    private String description;
}
