package com.f2f.dto.accWiz;

import com.f2f.enums.AccountLevel;
import com.f2f.enums.AccountNature;
import com.f2f.enums.DebitCreditType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImportAccountRow {

    private String code;

    private String name;

    private String parentCode;

    private AccountLevel level;

    private AccountNature nature;

    private DebitCreditType normalBalance;
}
