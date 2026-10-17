package ir.verjik.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GeneralLedgerAccountDto {
    private AccountsChartDto account;
    private List<LedgerEntryDto> entries;
}