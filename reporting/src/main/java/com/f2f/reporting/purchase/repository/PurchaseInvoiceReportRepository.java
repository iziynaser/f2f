package com.f2f.reporting.purchase.repository;

import com.f2f.entity.PurchaseInvoice;
import com.f2f.reporting.purchase.dto.SupplierPurchaseSummaryReportDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchaseInvoiceReportRepository extends JpaRepository<PurchaseInvoice, Long> {
    @Query("""
        SELECT new com.f2f.dto.report.SupplierPurchaseSummaryDTO(
            pi.supplier.id,
            CONCAT(pi.supplier.firstName, ' ', pi.supplier.lastName),
            COUNT(pi.id),
            SUM(pi.totalAmount)
        )
        FROM PurchaseInvoice pi
        GROUP BY pi.supplier.id, pi.supplier.firstName, pi.supplier.lastName
    """)
    List<SupplierPurchaseSummaryReportDTO> getPurchaseSummaryBySupplier();
}
