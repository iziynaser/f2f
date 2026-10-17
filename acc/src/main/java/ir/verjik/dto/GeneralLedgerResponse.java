package ir.verjik.dto;

import java.util.List;

public class GeneralLedgerResponse {
    private Long accountId;
    private String accountCode;
    private String accountName;
    private List<LedgerEntryResponse> entries;
}
