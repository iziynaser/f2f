package ir.verjik.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GeneralLedgerDto {
    private AccountingPeriodDto period;
    private List<GeneralLedgerAccountDto> accounts;
}