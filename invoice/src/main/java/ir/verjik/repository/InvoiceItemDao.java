package ir.verjik.repository;

import ir.verjik.entity.InvoiceItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("InvoiceItemDao")
@Repository
public interface InvoiceItemDao extends CrudRepository<InvoiceItem,Long> {
}
