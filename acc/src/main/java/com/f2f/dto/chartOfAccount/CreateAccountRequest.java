package com.f2f.dto.chartOfAccount;

import com.f2f.enums.AccountNature;
import com.f2f.enums.DebitCreditType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccountRequest {
    public Long parentId;
    public String name;
    public AccountNature accountNature;
    public DebitCreditType debitCreditType;
    public Boolean postable;
    public Boolean active;
    public String description;
}
