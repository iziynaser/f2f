package com.f2f.controller.account.invoice;

import com.f2f.entity.acc.invoice.InvoiceItem;
import com.f2f.service.account.invoice.InvoiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("InvoiceItemController")
@RequestMapping("/InvoiceItem")
public class InvoiceItemController {

    @Autowired
    InvoiceItemService invoiceItemService ;

    @GetMapping("/list")
    public List<InvoiceItem> listAll(){
        List<InvoiceItem> list = invoiceItemService.findAll();
        return list;
    }

}
