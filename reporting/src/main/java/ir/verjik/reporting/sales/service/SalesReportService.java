package ir.verjik.reporting.sales.service;

import ir.verjik.reporting.common.ProductSalesSummaryDTO;
import ir.verjik.reporting.sales.dto.DailySalesReportDTO;
import ir.verjik.reporting.sales.dto.ProductSalesReportDTO;
import ir.verjik.reporting.sales.dto.SalesReportDTO;
import ir.verjik.reporting.sales.repository.SalesInvoiceItemReportRepository;
import ir.verjik.repository.SalesInvoiceRepository;
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
