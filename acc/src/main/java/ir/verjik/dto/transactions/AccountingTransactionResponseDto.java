package ir.verjik.dto.transactions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class AccountingTransactionResponseDto {

    private Long id;

    private String transactionNumber;

    private String transactionType;

    private String transactionStatus;

    private LocalDate transactionDate;

    private String description;

    private PeriodDto period;

    private List<TransactionDetailDto> details;
}
