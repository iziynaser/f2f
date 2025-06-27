package com.f2f.controller.invoice;

import com.f2f.entity.invoice.InvoiceTerm;
import com.f2f.service.invoice.InvoiceTermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("InvoiceTermController")
@RequestMapping("/f2f/InvoiceTerm")
public class InvoiceTermController {

    @Autowired
    InvoiceTermService invoiceTermService ;

    @GetMapping("/list")
    public List<InvoiceTerm> getInvoiceTermList(){
        List<InvoiceTerm> list = invoiceTermService.findAll();
        return list;
    }
}
