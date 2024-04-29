package com.f2f.dao.acc.invoice;

import com.f2f.entity.acc.invoice.InvoiceItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("InvoiceItemDao")
public interface InvoiceItemDao extends CrudRepository<InvoiceItem,Long> {
}
