package ir.verjik.reporting.invoice.service;

import ir.verjik.dto.InvoiceDTO;
import ir.verjik.entity.Invoice;
import ir.verjik.mapper.InvoiceMapper;
import ir.verjik.reporting.common.DailySalesDTO;
import ir.verjik.reporting.common.ProductSalesSummaryDTO;
import ir.verjik.reporting.invoice.dto.InvoicePaymentStatusReportDTO;
import ir.verjik.reporting.invoice.dto.InvoiceTypeCountReportDTO;
import ir.verjik.reporting.invoice.dto.MonthlyInvoiceSummaryDTO;
import ir.verjik.reporting.invoice.repository.InvoiceReportRepository;
import ir.verjik.repository.InvoiceTypeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
