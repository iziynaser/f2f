package com.f2f.dao.invoice;

import com.f2f.entity.invoice.InvoiceTerm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("InvoiceTermDao")
@Repository
public interface InvoiceTermDao extends CrudRepository<InvoiceTerm,Long>{
}
