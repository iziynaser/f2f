package com.f2f.reporting.sales.service;

import com.f2f.reporting.common.ProductSalesSummaryDTO;
import com.f2f.reporting.sales.dto.DailySalesReportDTO;
import com.f2f.reporting.sales.dto.ProductSalesReportDTO;
import com.f2f.reporting.sales.dto.SalesReportDTO;
import com.f2f.reporting.sales.repository.SalesInvoiceItemReportRepository;
import com.f2f.repository.SalesInvoiceItemRepository;
import com.f2f.repository.SalesInvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesReportService {

    private final SalesInvoiceRepository salesInvoiceRepository;
    private final SalesInvoiceItemReportRepository salesInvoiceItemRepository;


    public List<DailySalesReportDTO> getDailyReport(LocalDate startDate, LocalDate endDate) {
        //return salesInvoiceRepository.getDailySalesReport(startDate, endDate);
        return null;
    }

    public SalesReportDTO getSalesReport(LocalDate start, LocalDate end) {
        //return salesInvoiceRepository.getSalesReportBetweenDates(start, end);
        return null;
    }

    public List<ProductSalesSummaryDTO> getProductSalesSummary() {
        return salesInvoiceItemRepository.getProductSalesSummary();
    }

    public List<ProductSalesReportDTO> getProductSalesReport(LocalDate startDate, LocalDate endDate) {
        return salesInvoiceItemRepository.findProductSalesReport(startDate, endDate);
    }
}
