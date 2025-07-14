package com.f2f.reporting.invoice.controller;

import com.f2f.reporting.invoice.dto.InvoicePaymentStatusReportDTO;
import com.f2f.reporting.invoice.service.InvoicePaymentStatusReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/invoices/payment-status")
@RequiredArgsConstructor
public class InvoicePaymentStatusReportController {

    private final InvoicePaymentStatusReportService invoicePaymentStatusReportService;

    @GetMapping
    public ResponseEntity<List<InvoicePaymentStatusReportDTO>> getInvoicesByPaymentStatus(
            @RequestParam String status) {
        List<InvoicePaymentStatusReportDTO> invoices = invoicePaymentStatusReportService.getInvoicesByPaymentStatus(status);
        if (invoices.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(invoices);
    }
}
