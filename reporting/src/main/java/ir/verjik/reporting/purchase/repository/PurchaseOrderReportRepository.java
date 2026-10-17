package ir.verjik.reporting.purchase.repository;

import ir.verjik.entity.PurchaseOrder;
import ir.verjik.reporting.purchase.dto.SupplierPerformanceReportDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchaseOrderReportRepository extends JpaRepository<PurchaseOrder, Long> {
    public boolean existsByOrderNumber(String orderNumber);

    @Query("""
        SELECT new com.f2f.dto.report.SupplierPerformanceDTO(
            po.supplier.id,
            CONCAT(po.supplier.firstName, ' ', po.supplier.lastName),
            COUNT(po.id),
            SUM(po.totalAmount),
            SUM(CASE WHEN pi.paymentStatus = 'PAID' THEN 1 ELSE 0 END),
            SUM(CASE WHEN pi.paymentStatus <> 'PAID' THEN 1 ELSE 0 END)
        )
        FROM PurchaseOrder po
        LEFT JOIN PurchaseInvoice pi ON pi.purchaseOrder.id = po.id
        GROUP BY po.supplier.id, po.supplier.firstName, po.supplier.lastName
    """)
    public List<SupplierPerformanceReportDTO> getSupplierPerformanceReport();

}
