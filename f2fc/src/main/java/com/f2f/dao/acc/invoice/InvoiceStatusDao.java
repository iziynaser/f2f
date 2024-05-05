package com.f2f.dao.acc.invoice;

import com.f2f.entity.acc.invoice.InvoiceStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("InvoiceStatusDao")
public interface InvoiceStatusDao extends CrudRepository<InvoiceStatus,Long>{
}
