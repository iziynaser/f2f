package com.f2f.controller.account.invoice;

import com.f2f.entity.acc.invoice.InvoiceRole;
import com.f2f.service.account.invoice.InvoiceRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("InvoiceRoleController")
@RequestMapping("/InvoiceRole")
public class InvoiceRoleController {

    @Autowired
    InvoiceRoleService invoiceRoleService ;

    @GetMapping("/list")
    public List<InvoiceRole> getInvoiceRoleList(){
        List<InvoiceRole> list = invoiceRoleService.findAll();
        return list;
    }
}
