package com.f2f.dto;

import com.f2f.enums.DebitCreditType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionItemRequest {

    public Long accountId;
    public BigDecimal debit;
    public BigDecimal credit;
    public String description;
    private DebitCreditType debitCreditType;
}
