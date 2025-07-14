package com.f2f.reporting.purchase.service;

import com.f2f.reporting.purchase.dto.SupplierPerformanceReportDTO;
import com.f2f.reporting.purchase.dto.SupplierPurchaseSummaryReportDTO;
import com.f2f.reporting.purchase.repository.PurchaseInvoiceReportRepository;
import com.f2f.reporting.purchase.repository.PurchaseOrderReportRepository;
import com.f2f.repository.PurchaseInvoiceRepository;
import com.f2f.repository.PurchaseOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseReportService {

    private final PurchaseInvoiceReportRepository purchaseInvoiceRepository;
    private final PurchaseOrderReportRepository purchaseOrderRepository;

    public List<SupplierPerformanceReportDTO> getSupplierPerformanceReport() {
        return purchaseOrderRepository.getSupplierPerformanceReport();
    }

    public List<SupplierPurchaseSummaryReportDTO> getPurchaseSummaryBySupplier() {
        return purchaseInvoiceRepository.getPurchaseSummaryBySupplier();
    }


}
