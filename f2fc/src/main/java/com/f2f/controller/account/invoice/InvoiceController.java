package com.f2f.controller.account.invoice;

import com.f2f.entity.acc.invoice.Invoice;
import com.f2f.service.account.invoice.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("InvoiceController")
@RequestMapping("/Invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/list")
    @PreAuthorize("isAnonymous()")
    public List<Invoice> getInvoiceList(){
        List<Invoice> list = invoiceService.findAll();
        return list;
    }

//    @GetMapping("/save")
//    public void saveInvoices(Invoice invoice){
//        System.out.println("invoice saved");
//        //invoiceService.save(invoice);
//    }

    @PostMapping("/save")
    public void saveInvoice(@RequestBody Invoice invoice) throws Exception{
        System.out.println("save mehthod called");
    }

}
