package ir.verjik.service;

import ir.verjik.entity.InvoiceType;
import ir.verjik.repository.InvoiceTypeDao;
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

    public void update(String invoiceType){
        //invoiceTypeDao.save(invoiceType);
    }

    public Optional<InvoiceType> getById(Long id){
        return invoiceTypeDao.findById(id);
    }
}
