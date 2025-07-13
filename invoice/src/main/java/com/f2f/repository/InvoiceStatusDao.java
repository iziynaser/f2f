package com.f2f.repository;

import com.f2f.entity.InvoiceStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("InvoiceStatusDao")
@Repository
public interface InvoiceStatusDao extends CrudRepository<InvoiceStatus,Long>{
}
