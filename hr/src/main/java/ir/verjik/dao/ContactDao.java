package ir.verjik.dao;

import ir.verjik.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("ContactDao")
@Repository
public interface ContactDao extends CrudRepository<Contact,Long> {

}
