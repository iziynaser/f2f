package ir.verjik.repository;

import ir.verjik.entity.InvoiceTerm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("InvoiceTermDao")
@Repository
public interface InvoiceTermDao extends CrudRepository<InvoiceTerm,Long>{
}
