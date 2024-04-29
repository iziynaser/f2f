package com.f2f.service.account.invoice;

import com.f2f.dao.acc.invoice.InvoiceActionTypesDao;
import com.f2f.entity.acc.invoice.InvoiceActionTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("InvoiceActionTypesService")
public class InvoiceActionTypesService {

    @Autowired
    InvoiceActionTypesDao invoiceActionTypesDao;

    public List<InvoiceActionTypes> findAll() {
         return (List<InvoiceActionTypes>)invoiceActionTypesDao.findAll();
    }
}
