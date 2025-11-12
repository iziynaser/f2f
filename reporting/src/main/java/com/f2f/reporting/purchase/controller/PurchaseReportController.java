package com.f2f.reporting.purchase.controller;

import com.f2f.reporting.purchase.dto.SupplierPerformanceReportDTO;
import com.f2f.reporting.purchase.dto.SupplierPurchaseSummaryReportDTO;
import com.f2f.reporting.purchase.service.PurchaseReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports/purchase")
@RequiredArgsConstructor
public class PurchaseReportController {

    private final PurchaseReportService purchaseReportService;

    @GetMapping("/by-supplier")
    public List<SupplierPurchaseSummaryReportDTO> getPurchaseSummaryBySupplier() {
        return purchaseReportService.getPurchaseSummaryBySupplier();
    }

    @GetMapping("/supplier-performance")
    public List<SupplierPerformanceReportDTO> getSupplierPerformanceReport() {
        return purchaseReportService.getSupplierPerformanceReport();
    }
}
