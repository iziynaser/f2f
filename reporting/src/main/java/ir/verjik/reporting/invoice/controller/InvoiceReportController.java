package ir.verjik.reporting.invoice.controller;

import ir.verjik.reporting.common.DailySalesDTO;
import ir.verjik.reporting.common.ProductSalesSummaryDTO;
import ir.verjik.reporting.invoice.dto.InvoicePaymentStatusReportDTO;
import ir.verjik.reporting.invoice.dto.InvoiceTypeCountReportDTO;
import ir.verjik.reporting.invoice.dto.MonthlyInvoiceSummaryDTO;
import ir.verjik.reporting.invoice.service.InvoiceReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports/invoice")
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
