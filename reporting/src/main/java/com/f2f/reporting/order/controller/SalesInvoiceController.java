package com.f2f.reporting.order.controller;

//@RestController
//@RequestMapping("/sales")
public class SalesInvoiceController {
//
//    private final SalesInvoiceService salesInvoiceService;
//
//    public SalesInvoiceController(SalesInvoiceService salesInvoiceService) {
//        this.salesInvoiceService = salesInvoiceService;
//    }
//
//    @PostMapping
//    public ResponseEntity<InvoiceDTO> createInvoice(@RequestBody InvoiceDTO dto) {
//        return ResponseEntity.ok(salesInvoiceService.createInvoice(dto));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<InvoiceDTO> getInvoice(@PathVariable Long id) {
//        Optional<InvoiceDTO> invoice = salesInvoiceService.getInvoiceById(id);
//        return invoice.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/customer/{customerId}")
//    public ResponseEntity<List<InvoiceDTO>> getInvoicesByCustomer(@PathVariable Long customerId) {
//        return ResponseEntity.ok(salesInvoiceService.getInvoicesByCustomerId(customerId));
//    }
//
//    @GetMapping("/order/{orderId}")
//    public ResponseEntity<List<InvoiceDTO>> getInvoicesByOrder(@PathVariable Long orderId) {
//        return ResponseEntity.ok(salesInvoiceService.getInvoicesByOrderId(orderId));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<InvoiceDTO> updateInvoice(@PathVariable Long id, @RequestBody InvoiceDTO dto) {
//        InvoiceDTO updated = salesInvoiceService.updateInvoice(id, dto);
//        if (updated == null) return ResponseEntity.notFound().build();
//        return ResponseEntity.ok(updated);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
//        salesInvoiceService.deleteInvoice(id);
//        return ResponseEntity.noContent().build();
//    }
}
