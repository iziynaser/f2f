package ir.verjik.reporting.invoice.controller;

import ir.verjik.reporting.invoice.dto.InvoicePaymentStatusReportDTO;
import ir.verjik.reporting.invoice.service.InvoicePaymentStatusReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/invoices/payment-status")
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
