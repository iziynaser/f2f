package com.f2f.service.account.invoice;

import com.f2f.dao.acc.invoice.InvoiceTypeDao;
import com.f2f.entity.acc.invoice.InvoiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("InvoiceTypeService")
public class InvoiceTypeService {

    @Autowired
    InvoiceTypeDao invoiceTypeDao;

    public List<InvoiceType> findAll() {
        return (List<InvoiceType>) invoiceTypeDao.findAll();
    }

    public void update(InvoiceType invoiceType){
        invoiceTypeDao.save(invoiceType);
    }

    public Optional<InvoiceType> getById(Long id){
        return invoiceTypeDao.findById(id);
    }
}
