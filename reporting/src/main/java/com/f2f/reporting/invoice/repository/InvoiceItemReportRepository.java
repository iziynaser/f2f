package com.f2f.reporting.invoice.repository;

import com.f2f.entity.InvoiceItem;
import com.f2f.reporting.common.ProductSalesSummaryDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceItemReportRepository extends CrudRepository<InvoiceItem,Long> {

    @Query("""
        SELECT new com.f2f.dto.report.ProductSalesSummaryDTO(
            ii.productItemId,
            SUM(ii.quantity),
            SUM(ii.totalPrice),
            COUNT(DISTINCT ii.invoice.id)
        )
        FROM InvoiceItem ii
        WHERE ii.invoice.invoiceType.name = :invoiceType
        GROUP BY ii.productItemId
        """)
    List<ProductSalesSummaryDTO> getSalesSummaryByProduct(@Param("invoiceType") String invoiceType);

}
