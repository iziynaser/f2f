package ir.verjik.repository;

import ir.verjik.entity.InvoiceActionType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("InvoiceActionTypesDao")
@Repository
public interface InvoiceActionTypesDao extends CrudRepository<InvoiceActionType,Long>{
}
