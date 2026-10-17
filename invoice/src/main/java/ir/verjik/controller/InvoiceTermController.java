package ir.verjik.controller;

import ir.verjik.entity.InvoiceTerm;
import ir.verjik.service.InvoiceTermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("InvoiceTermController")
@RequestMapping("/InvoiceTerm")
public class InvoiceTermController {

    @Autowired
    InvoiceTermService invoiceTermService ;

    @GetMapping("/list")
    public List<InvoiceTerm> getInvoiceTermList(){
        List<InvoiceTerm> list = invoiceTermService.findAll();
        return list;
    }
}
