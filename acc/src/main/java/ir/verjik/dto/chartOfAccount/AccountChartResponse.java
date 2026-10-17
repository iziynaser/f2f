package ir.verjik.dto.chartOfAccount;

import ir.verjik.enums.AccountNature;
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
