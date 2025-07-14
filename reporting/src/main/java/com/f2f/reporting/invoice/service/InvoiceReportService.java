package com.f2f.reporting.invoice.service;

import com.f2f.dto.InvoiceDTO;
import com.f2f.entity.Invoice;
import com.f2f.mapper.InvoiceMapper;
import com.f2f.reporting.common.DailySalesDTO;
import com.f2f.reporting.common.ProductSalesSummaryDTO;
import com.f2f.reporting.invoice.dto.InvoicePaymentStatusReportDTO;
import com.f2f.reporting.invoice.dto.InvoiceTypeCountReportDTO;
import com.f2f.reporting.invoice.dto.MonthlyInvoiceSummaryDTO;
import com.f2f.reporting.invoice.repository.InvoiceReportRepository;
import com.f2f.repository.InvoiceRepository;
import com.f2f.repository.InvoiceTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InvoiceReportService {

    private final InvoiceReportRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;
    private InvoiceTypeRepository invoiceTypeRepository;

    public InvoiceReportService(InvoiceReportRepository invoiceRepository, InvoiceMapper invoiceMapper){

        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
    }

    public Optional<InvoiceDTO> getInvoiceById(Long id) {
        //return invoiceRepository.findById(id).map(invoiceMapper::toDto);
        return Optional.empty();
    }

    public List<InvoiceDTO> getInvoicesByType(String invoiceType) {
        //List<Invoice> invoices = invoiceRepository.findByInvoiceType(invoiceType);
        //return invoices.stream().map(invoiceMapper::toDto).collect(Collectors.toList());
        return null;
    }

    public List<InvoiceDTO> getInvoicesByOrderId(Long orderId) {
        List<Invoice> invoices = invoiceRepository.findByOrderId(orderId);
        //return invoices.stream().map(invoiceMapper::toDto).collect(Collectors.toList());
        return null;
    }

    public List<InvoiceDTO> findAllAvailableInvoice() {
        return null;
    }

    public List<InvoicePaymentStatusReportDTO> getInvoicePaymentStatusReport() {
        return invoiceRepository.getInvoicePaymentStatusReport();
    }

    public List<InvoiceTypeCountReportDTO> getInvoiceTypeCountReport() {
        return invoiceRepository.getInvoiceCountByType();
    }

    public MonthlyInvoiceSummaryDTO getMonthlySummary() {
        LocalDate now = LocalDate.now();
        LocalDateTime start = now.withDayOfMonth(1).atStartOfDay();
        LocalDateTime end = start.plusMonths(1).minusSeconds(1);

        Long salesTotal = invoiceRepository.getTotalAmountByTypeAndDateRange("SALES", start, end);
        Long purchaseTotal = invoiceRepository.getTotalAmountByTypeAndDateRange("PURCHASE", start, end);

        MonthlyInvoiceSummaryDTO dto = new MonthlyInvoiceSummaryDTO();
        dto.setYear(now.getYear());
        dto.setMonth(now.getMonthValue());
        dto.setSalesTotal(salesTotal);
        dto.setPurchaseTotal(purchaseTotal);

        return dto;
    }

    public List<ProductSalesSummaryDTO> getSalesSummaryByProduct() {
        //return invoiceItemRepository.getSalesSummaryByProduct("SALES");
        return null;
    }

    public List<DailySalesDTO> getDailySalesReport() {
        return null;
    }
}
