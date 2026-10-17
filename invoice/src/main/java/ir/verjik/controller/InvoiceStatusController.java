package ir.verjik.controller;

import ir.verjik.entity.InvoiceStatus;
import ir.verjik.service.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("InvoiceStatusController")
@RequestMapping("/InvoiceStatus")
public class InvoiceStatusController {

    @Autowired
    InvoiceStatusService invoiceStatusService;

    @GetMapping("/list")
    public List<InvoiceStatus> getInvoiceStatusList(){
        List<InvoiceStatus> list = invoiceStatusService.findAll();
        return list;
    }

}
