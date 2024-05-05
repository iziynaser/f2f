package com.f2f.dao.contact;

import com.f2f.entity.hr.ContactType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("ContactTypeDao")
public interface ContactTypeDao extends CrudRepository<ContactType,Long> {

}
