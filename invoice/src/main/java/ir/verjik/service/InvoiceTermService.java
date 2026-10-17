package ir.verjik.service;

import ir.verjik.entity.InvoiceTerm;
import ir.verjik.repository.InvoiceTermDao;
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
