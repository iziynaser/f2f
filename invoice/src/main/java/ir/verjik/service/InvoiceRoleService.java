package ir.verjik.service;

import ir.verjik.entity.InvoiceRole;
import ir.verjik.repository.InvoiceRoleDao;
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
