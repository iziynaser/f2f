package com.f2f.controller;

//import com.f2f.dto.InvoiceDTO;
//import com.f2f.service.PurchaseInvoiceService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;

public class PurchaseInvoiceController {}
//
//@RestController
//@RequestMapping("/purchase-invoices")
//public class PurchaseInvoiceController {
//
//    private final PurchaseInvoiceService purchaseInvoiceService;
//
//    public PurchaseInvoiceController(PurchaseInvoiceService purchaseInvoiceService) {
//        this.purchaseInvoiceService = purchaseInvoiceService;
//    }
//
//    @PostMapping
//    public ResponseEntity<InvoiceDTO> createInvoice(@RequestBody InvoiceDTO dto) {
//        return ResponseEntity.ok(purchaseInvoiceService.createInvoice(dto));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<InvoiceDTO> getInvoice(@PathVariable Long id) {
//        Optional<InvoiceDTO> invoice = purchaseInvoiceService.getInvoiceById(id);
//        return invoice.map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/order/{orderId}")
//    public ResponseEntity<InvoiceDTO> getInvoiceByOrder(@PathVariable Long orderId) {
//        Optional<InvoiceDTO> invoice = purchaseInvoiceService.getInvoiceByOrderId(orderId);
//        return invoice.map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<InvoiceDTO> updateInvoice(@PathVariable Long id, @RequestBody InvoiceDTO dto) {
//        InvoiceDTO updated = purchaseInvoiceService.updateInvoice(id, dto);
//        if (updated == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(updated);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
//        purchaseInvoiceService.deleteInvoice(id);
//        return ResponseEntity.noContent().build();
//    }
//}
