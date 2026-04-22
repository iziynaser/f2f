package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountBalanceDto {
    private String accountCode;
    private String accountName;
    private BigDecimal balance;
}