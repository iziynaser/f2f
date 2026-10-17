package ir.verjik.service;


import ir.verjik.entity.InvoiceItem;
import ir.verjik.repository.InvoiceItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("InvoiceItemService")
public class InvoiceItemService {

    @Autowired
    InvoiceItemDao invoiceItemDao;

    public List<InvoiceItem> findAll() {
        return (List<InvoiceItem>) invoiceItemDao.findAll();
    }
}
