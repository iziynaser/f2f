package com.f2f.repository;

import com.f2f.entity.InvoiceActionTypes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("InvoiceActionTypesDao")
@Repository
public interface InvoiceActionTypesDao extends CrudRepository<InvoiceActionTypes,Long>{
}
