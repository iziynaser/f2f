package ir.verjik.reporting.sales.repository;

import ir.verjik.entity.SalesInvoiceItem;
import ir.verjik.reporting.common.ProductSalesSummaryDTO;
import ir.verjik.reporting.sales.dto.ProductSalesReportDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SalesInvoiceItemReportRepository extends JpaRepository<SalesInvoiceItem, Long> {
    @Query("""
        SELECT new ir.verjik.dto.report.ProductSalesSummaryDTO(
            sii.productItemId,
            SUM(sii.quantity),
            SUM(sii.finalPrice * sii.quantity)
        )
        FROM SalesInvoiceItem sii
        GROUP BY sii.productItemId
    """)
    List<ProductSalesSummaryDTO> getProductSalesSummary();

    @Query("""
        SELECT new ir.verjik.dto.report.ProductSalesReportDTO(
            sii.productItemId,
            pi.name,
            SUM(sii.quantity),
            SUM(sii.finalPrice * sii.quantity),
            COUNT(DISTINCT sii.invoice.id)
        )
        FROM SalesInvoiceItem sii
        JOIN ProductItem pi ON pi.id = sii.productItemId
        JOIN SalesInvoice si ON si.id = sii.invoice.id
        WHERE si.invoiceDate BETWEEN :startDate AND :endDate
        GROUP BY sii.productItemId, pi.name
    """)
    List<ProductSalesReportDTO> findProductSalesReport(LocalDate startDate, LocalDate endDate);


}