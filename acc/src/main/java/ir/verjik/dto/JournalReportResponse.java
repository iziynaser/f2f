package ir.verjik.dto;

import ir.verjik.dto.chartOfAccount.TransactionLineResponse;

import java.time.LocalDate;
import java.util.List;

public class JournalReportResponse {
    private String transactionNumber;
    private LocalDate date;
    private String status;
    private String description;
    private List<TransactionLineResponse> lines;
}
