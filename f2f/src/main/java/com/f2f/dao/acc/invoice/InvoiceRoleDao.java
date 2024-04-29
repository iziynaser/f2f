package com.f2f.dao.acc.invoice;

import com.f2f.entity.acc.invoice.InvoiceRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("InvoiceRoleDao")
public interface InvoiceRoleDao extends CrudRepository<InvoiceRole,Long>{
}
