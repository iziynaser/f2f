package ir.verjik.dto.transactions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeriodDto {

    private Long id;

    private String periodName;

    private Integer fiscalYear;
}
