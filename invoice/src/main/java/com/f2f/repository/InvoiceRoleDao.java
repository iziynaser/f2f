package com.f2f.repository;

import com.f2f.entity.InvoiceRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("InvoiceRoleDao")
@Repository
public interface InvoiceRoleDao extends CrudRepository<InvoiceRole,Long>{
}
