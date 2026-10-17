package ir.verjik.reporting.purchase.repository;

import ir.verjik.entity.PurchaseInvoice;
import ir.verjik.reporting.purchase.dto.SupplierPurchaseSummaryReportDTO;
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
