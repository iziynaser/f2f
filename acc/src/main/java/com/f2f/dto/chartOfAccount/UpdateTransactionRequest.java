package com.f2f.dto.chartOfAccount;

import java.time.LocalDate;
import java.util.List;

/*
ویرایش سند
 */
public class UpdateTransactionRequest {
    private LocalDate transactionDate;
    private String description;
    private List<TransactionLineRequest> lines;
}
