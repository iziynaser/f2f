package com.f2f.reporting.invoice.service;

import com.f2f.entity.Invoice;
import com.f2f.reporting.invoice.dto.InvoicePaymentStatusReportDTO;
import com.f2f.reporting.invoice.repository.InvoiceReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvoicePaymentStatusReportService {

    private final InvoiceReportRepository invoiceRepository;

    public List<InvoicePaymentStatusReportDTO> getInvoicesByPaymentStatus(String paymentStatus) {
        List<Invoice> invoices = invoiceRepository.findByPaymentStatus(paymentStatus);
        return invoices.stream().map(invoice -> {
            InvoicePaymentStatusReportDTO dto = new InvoicePaymentStatusReportDTO();
            dto.setInvoiceId(invoice.getId());
            dto.setInvoiceNumber(invoice.getInvoiceNumber());
            dto.setInvoiceDate(invoice.getInvoiceDate());
            dto.setPaymentStatus(invoice.getPaymentStatus());
            dto.setTotalAmount(invoice.getTotalAmount());
            dto.setPaidAmount(invoice.getPaidAmount());
            return dto;
        }).collect(Collectors.toList());
    }
}
