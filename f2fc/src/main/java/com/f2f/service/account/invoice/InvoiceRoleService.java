package com.f2f.service.account.invoice;

import com.f2f.dao.acc.invoice.InvoiceRoleDao;
import com.f2f.entity.acc.invoice.InvoiceRole;
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
