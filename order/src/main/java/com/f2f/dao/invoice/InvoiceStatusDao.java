package com.f2f.dao.invoice;

import com.f2f.entity.invoice.InvoiceStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("InvoiceStatusDao")
@Repository
public interface InvoiceStatusDao extends CrudRepository<InvoiceStatus,Long>{
}
