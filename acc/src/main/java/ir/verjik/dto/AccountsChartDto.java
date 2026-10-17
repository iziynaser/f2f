package ir.verjik.dto;

import ir.verjik.entity.AccountType;

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
