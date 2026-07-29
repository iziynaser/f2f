package com.f2f.dto.transactions;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionDetailDto {

    private Long id;

    private Integer sequenceId;

    private String debitCreditType;

    private BigDecimal amountFunctional;

    private String accountCode;

    private String accountName;

    private String description;
}
