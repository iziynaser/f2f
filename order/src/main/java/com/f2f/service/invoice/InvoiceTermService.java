package com.f2f.service.invoice;

import com.f2f.dao.invoice.InvoiceTermDao;
import com.f2f.entity.invoice.InvoiceTerm;
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
