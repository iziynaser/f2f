package com.f2f.dao.invoice;

import com.f2f.entity.invoice.InvoiceRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("InvoiceRoleDao")
@Repository
public interface InvoiceRoleDao extends CrudRepository<InvoiceRole,Long>{
}
