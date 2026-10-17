package ir.verjik.repository;

import ir.verjik.entity.InvoiceStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("InvoiceStatusDao")
@Repository
public interface InvoiceStatusDao extends CrudRepository<InvoiceStatus,Long>{
}
