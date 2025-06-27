package com.f2f.dao.invoice;

import com.f2f.entity.invoice.InvoiceItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("InvoiceItemDao")
@Repository
public interface InvoiceItemDao extends CrudRepository<InvoiceItem,Long> {
}
