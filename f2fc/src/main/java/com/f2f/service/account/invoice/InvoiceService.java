package com.f2f.service.account.invoice;

import com.f2f.dao.acc.invoice.InvoiceDao;
import com.f2f.entity.acc.invoice.Invoice;
import com.f2f.entity.acc.invoice.InvoiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("InvoiceService")
public class InvoiceService {

    @Autowired
    InvoiceDao invoiceDao;

    public List<InvoiceDTO> findAllAvailableInvoice() {
        return (List<InvoiceDTO>) invoiceDao.findAllAvailableInvoice();
    }

    public void save(Invoice invoice){
        invoiceDao.save(invoice);
    }
}
