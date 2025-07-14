package com.f2f.reporting.sales.service;

import com.f2f.entity.SalesInvoice;
import com.f2f.reporting.sales.dto.SalesInvoiceReportDTO;
import com.f2f.reporting.sales.repository.SalesInvoiceReportRepository;
import com.f2f.repository.SalesInvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SalesInvoiceReportService {

    private final SalesInvoiceReportRepository salesInvoiceRepository;

    public List<SalesInvoiceReportDTO> getInvoicesBetweenDates(LocalDate startDate, LocalDate endDate) {
        List<SalesInvoice> invoices = salesInvoiceRepository.findByInvoiceDateBetween(startDate, endDate);
        return invoices.stream().map(invoice -> {
            SalesInvoiceReportDTO dto = new SalesInvoiceReportDTO();
            dto.setId(invoice.getId());
            dto.setInvoiceNumber(invoice.getInvoiceNumber());
            dto.setInvoiceDate(invoice.getInvoiceDate());
            dto.setStatus(invoice.getStatus());
            dto.setTotalAmount(invoice.getTotalAmount());
            return dto;
        }).collect(Collectors.toList());
    }
}
