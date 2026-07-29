package com.f2f.controller;

import com.f2f.dto.chartOfAccount.CreatePeriodRequest;
import com.f2f.dto.chartOfAccount.PeriodResponse;
import com.f2f.service.OpeningBalanceService;
import com.f2f.service.PeriodClosingService;
import com.f2f.service.PeriodOpeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
مدیریت دوره های مالی
سرویس های مربوط به بازکردن ، بستن ، ایجاد مانده افتتاحیه
 */
@RestController
@RequestMapping("/api/v1/periods")
@RequiredArgsConstructor
public class PeriodController {

    private final PeriodOpeningService periodService;
    private final PeriodOpeningService periodOpeningService;
    private final PeriodClosingService periodClosingService;
    private final OpeningBalanceService openingBalanceService;

    @PostMapping
    public ResponseEntity<PeriodResponse> createPeriod(
            @RequestBody CreatePeriodRequest request) {

        periodService.openPeriod(new Long("1"));
        PeriodResponse periodResponse = new PeriodResponse();
        return ResponseEntity.status(HttpStatus.CREATED).body(periodResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeriodResponse> getPeriod(@PathVariable Long id) {
        //var result = periodService.getPeriod(id);
        //return ResponseEntity.ok(result);
        return null;
    }

    @GetMapping
    public ResponseEntity<List<PeriodResponse>> listPeriods() {
        //var result = periodService.getAllPeriods();
        //return ResponseEntity.ok(result);
        return null;
    }

    @PostMapping("/{id}/open")
    public ResponseEntity<PeriodResponse> openPeriod(@PathVariable Long id) {
        //var result = periodOpeningService.openPeriod(id);
        //return ResponseEntity.ok(result);
        return null;
    }

    @PostMapping("/{id}/close")
    public ResponseEntity<PeriodResponse> closePeriod(@PathVariable Long id) {
        //var result = periodClosingService.closePeriod(id);
        //return ResponseEntity.ok(result);
        return null;
    }

    @PostMapping("/{id}/opening-balance")
    public ResponseEntity<Void> generateOpeningBalance(@PathVariable Long id) {
        //openingBalanceService.generateOpeningBalance(id);
        //return ResponseEntity.ok().build();
        return null;
    }
}
