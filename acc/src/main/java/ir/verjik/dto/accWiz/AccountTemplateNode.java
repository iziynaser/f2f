package ir.verjik.dto.accWiz;

import ir.verjik.enums.AccountLevel;
import ir.verjik.enums.AccountNature;
import ir.verjik.enums.DebitCreditType;
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
