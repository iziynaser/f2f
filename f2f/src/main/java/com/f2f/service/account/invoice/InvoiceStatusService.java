package com.f2f.service.account.invoice;

import com.f2f.dao.acc.invoice.InvoiceStatusDao;
import com.f2f.entity.acc.invoice.InvoiceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("InvoiceStatusService")
public class InvoiceStatusService {

    @Autowired
    InvoiceStatusDao invoiceStatusDao;

    public List<InvoiceStatus> findAll() {
        return (List<InvoiceStatus>) invoiceStatusDao.findAll();
    }
}

