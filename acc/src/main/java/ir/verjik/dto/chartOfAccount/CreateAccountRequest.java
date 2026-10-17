package ir.verjik.dto.chartOfAccount;

import ir.verjik.enums.AccountNature;
import ir.verjik.enums.DebitCreditType;
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
