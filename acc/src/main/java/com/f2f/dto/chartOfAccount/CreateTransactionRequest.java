package com.f2f.dto.chartOfAccount;

import com.f2f.dto.TransactionItemRequest;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CreateTransactionRequest {
    private LocalDate transactionDate;
    private Long periodId;
    private String description;
    private List<TransactionItemRequest> items;
}
