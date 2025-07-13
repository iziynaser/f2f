package com.f2f.service;

import com.f2f.entity.InvoiceTerm;
import com.f2f.repository.InvoiceTermDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("InvoiceTermService")
public class InvoiceTermService {

    @Autowired
    InvoiceTermDao invoiceTermDao;

    public List<InvoiceTerm> findAll() {
        return (List<InvoiceTerm>) invoiceTermDao.findAll();
    }
}
