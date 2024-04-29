package com.f2f.dao.acc.invoice;

import com.f2f.entity.acc.invoice.InvoiceTerm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("InvoiceTermDao")
public interface InvoiceTermDao extends CrudRepository<InvoiceTerm,Long>{
}
