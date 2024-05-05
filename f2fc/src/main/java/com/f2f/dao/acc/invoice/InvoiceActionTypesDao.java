package com.f2f.dao.acc.invoice;

import com.f2f.entity.acc.invoice.InvoiceActionTypes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("InvoiceActionTypesDao")
public interface InvoiceActionTypesDao extends CrudRepository<InvoiceActionTypes,Long>{
}
