package com.f2f.service;

import com.f2f.entity.InvoiceRole;
import com.f2f.repository.InvoiceRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("InvoiceRoleService")
public class InvoiceRoleService {

    @Autowired
    InvoiceRoleDao invoiceRoleDao;

    public List<InvoiceRole> findAll() {
        return (List<InvoiceRole>) invoiceRoleDao.findAll();
    }
}
