package com.f2f.dto;

import com.f2f.entity.AccountType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountsChartDto {

    private String name;//name

    private String accountCode ;

    private String description;

    private String color;

    private String status;

    private AccountType accountType;

}
