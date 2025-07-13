package com.f2f.service;

import com.f2f.entity.InvoiceActionTypes;
import com.f2f.repository.InvoiceActionTypesDao;
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
