package ir.verjik.controller;

import ir.verjik.entity.InvoiceActionType;
import ir.verjik.service.InvoiceActionTypesService;
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
    public List<InvoiceActionType> getInvoiceActionTypesList(){
        List<InvoiceActionType> list = invoiceActionTypesService.findAll();
        return list;
    }

}
