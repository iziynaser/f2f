package com.f2f.controller.invoice;

import com.f2f.entity.invoice.InvoiceStatus;
import com.f2f.service.invoice.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("InvoiceStatusController")
@RequestMapping("/f2f/InvoiceStatus")
public class InvoiceStatusController {

    @Autowired
    InvoiceStatusService invoiceStatusService;

    @GetMapping("/list")
    public List<InvoiceStatus> getInvoiceStatusList(){
        List<InvoiceStatus> list = invoiceStatusService.findAll();
        return list;
    }

}
