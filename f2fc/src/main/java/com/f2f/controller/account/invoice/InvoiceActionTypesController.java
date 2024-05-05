package com.f2f.controller.account.invoice;

import com.f2f.entity.acc.invoice.InvoiceActionTypes;
import com.f2f.service.account.invoice.InvoiceActionTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("InvoiceActionTypesController")
@RequestMapping("/InvoiceActionTypes")
public class InvoiceActionTypesController {

    @Autowired
    InvoiceActionTypesService invoiceActionTypesService;

    @GetMapping("/list")
    public List<InvoiceActionTypes> getInvoiceActionTypesList(){
        List<InvoiceActionTypes> list = invoiceActionTypesService.findAll();
        return list;
    }

}
