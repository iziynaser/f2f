package ir.verjik.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class AccountingTransactionCreateDTO {

    LocalDate date;
    String description;
    List<AccountTransactionDetailCreateDTO> details;
}
