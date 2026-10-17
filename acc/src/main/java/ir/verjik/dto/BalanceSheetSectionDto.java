package ir.verjik.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class BalanceSheetSectionDto {
    private String sectionName; // مثلاً "دارایی‌های جاری"
    private List<AccountBalanceDTO> accounts;
    private BigDecimal total;
}

