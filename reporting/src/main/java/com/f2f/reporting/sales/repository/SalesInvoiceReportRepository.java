package com.f2f.reporting.sales.repository;

import com.f2f.entity.SalesInvoice;
import com.f2f.reporting.sales.dto.DailySalesReportDTO;
import com.f2f.reporting.sales.dto.SalesReportDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SalesInvoiceReportRepository extends JpaRepository<SalesInvoice, Long> {

    List<SalesInvoice> findByInvoiceDateBetween(LocalDate startDate, LocalDate endDate);

    @Query("SELECT new com.f2f.dto.DailySalesReportDTO(i.invoiceDate, COUNT(i), SUM(i.totalAmount)) " +
            "FROM SalesInvoice i " +
            "WHERE i.status = 'PAID' AND i.invoiceDate BETWEEN :startDate AND :endDate " +
            "GROUP BY i.invoiceDate")
    List<DailySalesReportDTO> getDailySalesReport(@Param("startDate") LocalDate startDate,
                                                  @Param("endDate") LocalDate endDate);

        @Query("""
        SELECT new com.f2f.dto.SalesReportDTO(
            :startDate,
            :endDate,
            COALESCE(SUM(i.totalAmount), 0),
            COUNT(i)
        )
        FROM SalesInvoice i
        WHERE i.invoiceDate BETWEEN :startDate AND :endDate
          AND i.status = com.f2f.enums.SalesStatus.PAID
    """)
        SalesReportDTO getSalesReportBetweenDates(LocalDate startDate, LocalDate endDate);

}