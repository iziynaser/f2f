package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CreateTransactionRequest {

    public LocalDate transactionDate;
    public String description;

    public List<TransactionItemRequest> items;

}
