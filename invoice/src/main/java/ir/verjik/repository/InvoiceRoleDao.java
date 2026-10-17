package ir.verjik.repository;

import ir.verjik.entity.InvoiceRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("InvoiceRoleDao")
@Repository
public interface InvoiceRoleDao extends CrudRepository<InvoiceRole,Long>{
}
