package ir.verjik.dao.contact;

import ir.verjik.entity.ContactType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("ContactTypeDao")
@Repository
public interface ContactTypeDao extends CrudRepository<ContactType,Long> {

}
