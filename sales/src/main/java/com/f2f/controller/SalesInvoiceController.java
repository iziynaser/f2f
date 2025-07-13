package com.f2f.controller;

import com.f2f.dto.SalesInvoiceDTO;
import com.f2f.enums.SalesStatus;
import com.f2f.service.SalesInvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales/invoices")
@RequiredArgsConstructor
public class SalesInvoiceController {

    private final SalesInvoiceService salesInvoiceService;

    // ایجاد فاکتور جدید
    @PostMapping
    public ResponseEntity<SalesInvoiceDTO> createInvoice(@RequestBody SalesInvoiceDTO invoiceDTO) {
        SalesInvoiceDTO savedInvoice = salesInvoiceService.createInvoice(invoiceDTO);
        return ResponseEntity.ok(savedInvoice);
    }

    // دریافت لیست همه فاکتورها
    @GetMapping
    public ResponseEntity<List<SalesInvoiceDTO>> getAllInvoices() {
        return ResponseEntity.ok(salesInvoiceService.getAllInvoices());
    }

    // دریافت یک فاکتور خاص بر اساس ID
    @GetMapping("/{id}")
    public ResponseEntity<SalesInvoiceDTO> getInvoiceById(@PathVariable Long id) {
        return salesInvoiceService.getInvoiceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // تغییر وضعیت فاکتور
    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> updateInvoiceStatus(@PathVariable Long id,
                                                    @RequestParam SalesStatus status) {
        salesInvoiceService.updateStatus(id, status);
        return ResponseEntity.noContent().build();
    }
}
