package com.f2f.dto.chartOfAccount;

import java.math.BigDecimal;

public class TransactionLineRequest {
    private Long accountId;
    private BigDecimal debit;
    private BigDecimal credit;
    private String description;
}
