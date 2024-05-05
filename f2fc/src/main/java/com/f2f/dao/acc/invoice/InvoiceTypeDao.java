package com.f2f.dao.acc.invoice;

import com.f2f.entity.acc.invoice.InvoiceType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("InvoiceTypeDao")
public interface InvoiceTypeDao extends CrudRepository<InvoiceType,Long>{
}
