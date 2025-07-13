package com.f2f.service;

import com.f2f.entity.InvoiceStatus;
import com.f2f.repository.InvoiceStatusDao;
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

