package ir.verjik.controller;

import ir.verjik.dto.AccountBalanceResponse;
import ir.verjik.dto.GeneralLedgerResponse;
import ir.verjik.dto.JournalReportResponse;
import ir.verjik.dto.TrialBalanceResponse;
import ir.verjik.service.JournalReportService;
import ir.verjik.service.LedgerService;
import ir.verjik.service.SubsidiaryLedgerReportService;
import ir.verjik.service.TrialBalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/reports")
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReportController {

    private final TrialBalanceService trialBalanceService;
    private final LedgerService ledgerService;
    private final SubsidiaryLedgerReportService subsidiaryLedgerReportService;
    private final TrialBalanceService accountBalanceQueryService;
    private final JournalReportService journalReportService;

    @GetMapping("/trial-balance")
    public ResponseEntity<TrialBalanceResponse> getTrialBalance(
            @RequestParam(required = false) Long periodId,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate,
            @RequestParam(required = false) Integer level) {

        //var result = trialBalanceService.generate(periodId, fromDate, toDate, level);
        //return ResponseEntity.ok(result);
        return null;
    }

    @GetMapping("/general-ledger")
    public ResponseEntity<List<GeneralLedgerResponse>> getGeneralLedger(
            @RequestParam Long periodId,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate) {

        //var result = ledgerService.generateGeneralLedger(periodId, fromDate, toDate);
        //return ResponseEntity.ok(result);
        return null;
    }

    @GetMapping("/account-ledger")
    public ResponseEntity<GeneralLedgerResponse> getAccountLedger(
            @RequestParam Long accountId,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate) {

        //var result = subsidiaryLedgerReportService.generate(accountId, fromDate, toDate);
        //return ResponseEntity.ok(result);
        return null;
    }

    @GetMapping("/journal")
    public ResponseEntity<List<JournalReportResponse>> getJournalReport(
            @RequestParam Long periodId,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate) {

        //var result = journalReportService.generate(periodId, fromDate, toDate);
        //return ResponseEntity.ok(result);
        return null;
    }

    @GetMapping("/account-balance")
    public ResponseEntity<AccountBalanceResponse> getAccountBalance(
            @RequestParam Long accountId,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate asOfDate) {

        //var result = accountBalanceQueryService.getBalance(accountId, asOfDate);
        //return ResponseEntity.ok(result);
        return null;
    }
}
