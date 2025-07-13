package com.f2f.service;


import com.f2f.entity.InvoiceItem;
import com.f2f.repository.InvoiceItemDao;
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
