package com.f2f.dto.chartOfAccount;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/*
خروجی سند
 */
@Getter
@Setter
public class TransactionResponse {
    private Long id;
    private String number;
    private LocalDate transactionDate;
    private String status; // DRAFT, POSTED, LOCKED
    private String description;
    private List<TransactionLineResponse> lines;
}
