package ir.verjik.dto.chartOfAccount;

import ir.verjik.dto.TransactionItemRequest;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CreateTransactionRequest {
    private LocalDate transactionDate;
    private Long periodId;
    private String description;
    private List<TransactionItemRequest> items;
}
