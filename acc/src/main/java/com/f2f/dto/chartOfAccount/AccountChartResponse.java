package com.f2f.dto.chartOfAccount;

import com.f2f.enums.AccountNature;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountChartResponse {
    private Long id;
    private String name;
    private String accountCode;
    private Long parentId;
    private String description;
    AccountNature accountNature;

}
