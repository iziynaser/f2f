package com.f2f.dao.invoice;

import com.f2f.entity.invoice.InvoiceActionTypes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("InvoiceActionTypesDao")
@Repository
public interface InvoiceActionTypesDao extends CrudRepository<InvoiceActionTypes,Long>{
}
