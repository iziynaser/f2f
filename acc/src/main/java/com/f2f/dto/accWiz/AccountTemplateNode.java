package com.f2f.dto.accWiz;

import com.f2f.enums.AccountLevel;
import com.f2f.enums.AccountNature;
import com.f2f.enums.DebitCreditType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AccountTemplateNode {

    private String code;

    private String name;

    private String description;

    private AccountLevel level;

    private AccountNature nature;

    private DebitCreditType normalBalance;

    private Boolean postable;

    private Boolean controlAccount;

    private List<AccountTemplateNode> children;
}
