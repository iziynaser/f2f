package com.f2f.controller;

    
import com.f2f.dto.InvoiceDTO;
import com.f2f.entity.Invoice;
import com.f2f.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
package com.f2f.controller;

import com.f2f.dto.InvoiceDTO;
import com.f2f.service.InvoiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public ResponseEntity<InvoiceDTO> createInvoice(@RequestBody InvoiceDTO dto) {
        return ResponseEntity.ok(invoiceService.createInvoice(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDTO> getInvoice(@PathVariable Long id) {
        Optional<InvoiceDTO> invoice = invoiceService.getInvoiceById(id);
        return invoice.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/type/{invoiceType}")
    public ResponseEntity<List<InvoiceDTO>> getInvoicesByType(@PathVariable String invoiceType) {
        return ResponseEntity.ok(invoiceService.getInvoicesByType(invoiceType));
    }

    @GetMapping("/party/{partyId}")
    public ResponseEntity<List<InvoiceDTO>> getInvoicesByParty(@PathVariable Long partyId) {
        return ResponseEntity.ok(invoiceService.getInvoicesByPartyId(partyId));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<InvoiceDTO>> getInvoicesByOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(invoiceService.getInvoicesByOrderId(orderId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceDTO> updateInvoice(@PathVariable Long id, @RequestBody InvoiceDTO dto) {
        InvoiceDTO updated = invoiceService.updateInvoice(id, dto);
        if

 */

@Controller("InvoiceController")
@RequestMapping("/f2f/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/list")
    public List<InvoiceDTO> getInvoiceList(){
        List<InvoiceDTO> list = invoiceService.findAllAvailableInvoice();
        return list;
    }

    @GetMapping("/lInvoice")
    @ResponseBody
    public List<InvoiceDTO> findAllAvailableInvoice(){
        List<InvoiceDTO> list = invoiceService.findAllAvailableInvoice();
        return list;
    }

//    @GetMapping("/save")
//    public void saveInvoices(Invoice invoice){
//        System.out.println("invoice saved");
//        //invoiceService.save(invoice);
//    }

    @ResponseBody
    @PostMapping("/save")
    public void saveInvoice(@RequestBody Invoice invoice) {
        System.out.println("save mehthod called");
        invoiceService.save(invoice);
    }

}
