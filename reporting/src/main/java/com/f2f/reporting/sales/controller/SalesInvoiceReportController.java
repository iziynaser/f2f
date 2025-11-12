package com.f2f.reporting.sales.controller;

import com.f2f.reporting.sales.dto.SalesInvoiceReportDTO;
import com.f2f.reporting.sales.service.SalesInvoiceReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/sales-invoices/reports")
@RequiredArgsConstructor
public class SalesInvoiceReportController {

    private final SalesInvoiceReportService salesInvoiceReportService;

    @GetMapping
    public ResponseEntity<List<SalesInvoiceReportDTO>> getInvoicesByDateRange(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        List<SalesInvoiceReportDTO> result = salesInvoiceReportService.getInvoicesBetweenDates(startDate, endDate);
        if (result.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }
}
