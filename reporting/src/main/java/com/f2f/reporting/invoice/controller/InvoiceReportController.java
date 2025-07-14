package com.f2f.reporting.invoice.controller;

import com.f2f.dto.InvoiceDTO;
import com.f2f.reporting.common.DailySalesDTO;
import com.f2f.reporting.common.ProductSalesSummaryDTO;
import com.f2f.reporting.invoice.dto.InvoicePaymentStatusReportDTO;
import com.f2f.reporting.invoice.dto.InvoiceTypeCountReportDTO;
import com.f2f.reporting.invoice.dto.MonthlyInvoiceSummaryDTO;
import com.f2f.reporting.invoice.service.InvoiceReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports/invoice")
@RequiredArgsConstructor
public class InvoiceReportController {

    private final InvoiceReportService reportService;

    @GetMapping("/sales-summary-by-product")
    public List<ProductSalesSummaryDTO> getSalesSummaryByProduct() {
        return reportService.getSalesSummaryByProduct();
    }

    @GetMapping("/payment-status")
    public List<InvoicePaymentStatusReportDTO> getPaymentStatusReport() {
        return reportService.getInvoicePaymentStatusReport();
    }

    @GetMapping("/type-count")
    public List<InvoiceTypeCountReportDTO> getInvoiceTypeCountReport() {
        return reportService.getInvoiceTypeCountReport();
    }

    @GetMapping("/monthly-summary")
    public MonthlyInvoiceSummaryDTO getMonthlyInvoiceSummary() {
        return reportService.getMonthlySummary();
    }

    @GetMapping("/reports/daily-sales")
    public ResponseEntity<List<DailySalesDTO>> getDailySalesReport() {
        return ResponseEntity.ok(reportService.getDailySalesReport());
    }

}
