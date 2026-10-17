package ir.verjik.service;

import ir.verjik.entity.InvoiceActionType;
import ir.verjik.repository.InvoiceActionTypesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("InvoiceActionTypesService")
public class InvoiceActionTypesService {

    @Autowired
    InvoiceActionTypesDao invoiceActionTypesDao;

    public List<InvoiceActionType> findAll() {
         return (List<InvoiceActionType>)invoiceActionTypesDao.findAll();
    }
}
