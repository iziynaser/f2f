package com.f2f.service.account.invoice;

import com.f2f.dao.acc.invoice.InvoiceItemDao;
import com.f2f.entity.acc.invoice.InvoiceItem;
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
