package ir.verjik.dto.accWiz;

import ir.verjik.enums.AccountLevel;
import ir.verjik.enums.AccountNature;
import ir.verjik.enums.DebitCreditType;
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
