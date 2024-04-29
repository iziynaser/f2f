package com.f2f.controller.account.invoice;

import com.f2f.entity.acc.invoice.InvoiceType;
import com.f2f.service.account.invoice.InvoiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("InvoiceTypeController")
@RequestMapping("/f2f/InvoiceType")
public class InvoiceTypeController {

    @Autowired
    InvoiceTypeService invoiceTypeService ;

    @GetMapping("/list")
    public List<InvoiceType> getInvoiceTypeList(){
        List<InvoiceType> list = invoiceTypeService.findAll();
        return list;
    }

    @RequestMapping(method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void update(@RequestBody InvoiceType invoiceType){
        invoiceTypeService.update(invoiceType);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    Optional<InvoiceType> get(@PathVariable Long id){
        return invoiceTypeService.getById(id);
    }

}
