package com.f2f.reporting.sales.controller;

import com.f2f.reporting.common.ProductSalesSummaryDTO;
import com.f2f.reporting.sales.dto.DailySalesReportDTO;
import com.f2f.reporting.sales.dto.ProductSalesReportDTO;
import com.f2f.reporting.sales.dto.SalesReportDTO;
import com.f2f.reporting.sales.service.SalesReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/sales/reports")
@RequiredArgsConstructor
public class SalesReportController {

    private final SalesReportService reportService;
    private final SalesReportService salesReportService;

    @GetMapping("/product-sales")
    public List<ProductSalesReportDTO> getProductSalesReport(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate
    ) {
        return salesReportService.getProductSalesReport(startDate, endDate);
    }
    @GetMapping("/by-product")
    public List<ProductSalesSummaryDTO> getProductSalesSummary() {
        return salesReportService.getProductSalesSummary();
    }

    @GetMapping("/daily")
    public ResponseEntity<List<DailySalesReportDTO>> getDailySales(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        List<DailySalesReportDTO> report = reportService.getDailyReport(startDate, endDate);
        return ResponseEntity.ok(report);
    }

    @GetMapping("/summary")
    public ResponseEntity<SalesReportDTO> getSalesSummary(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end
    ) {
        return ResponseEntity.ok(salesReportService.getSalesReport(start, end));
    }
}
