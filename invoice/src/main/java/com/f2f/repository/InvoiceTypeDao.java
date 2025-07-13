package com.f2f.repository;
import com.f2f.entity.InvoiceType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("InvoiceTypeDao")
@Repository
public interface InvoiceTypeDao extends CrudRepository<InvoiceType,Long>{
}
