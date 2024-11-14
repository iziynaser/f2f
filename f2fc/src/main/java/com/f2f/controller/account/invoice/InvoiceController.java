package com.f2f.controller.account.invoice;

import com.f2f.entity.acc.invoice.Invoice;
import com.f2f.entity.acc.invoice.InvoiceDTO;
import com.f2f.service.account.invoice.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
