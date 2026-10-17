package ir.verjik.reporting.purchase.service;

import ir.verjik.reporting.purchase.dto.SupplierPerformanceReportDTO;
import ir.verjik.reporting.purchase.dto.SupplierPurchaseSummaryReportDTO;
import ir.verjik.reporting.purchase.repository.PurchaseInvoiceReportRepository;
import ir.verjik.reporting.purchase.repository.PurchaseOrderReportRepository;
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
