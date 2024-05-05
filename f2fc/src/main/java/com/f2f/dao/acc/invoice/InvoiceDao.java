package com.f2f.dao.acc.invoice;

import com.f2f.entity.acc.invoice.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("InvoiceDao")
public interface InvoiceDao extends CrudRepository<Invoice,Long>{

}
