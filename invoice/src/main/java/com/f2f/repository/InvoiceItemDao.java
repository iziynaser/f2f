package com.f2f.repository;

import com.f2f.entity.InvoiceItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("InvoiceItemDao")
@Repository
public interface InvoiceItemDao extends CrudRepository<InvoiceItem,Long> {
}
