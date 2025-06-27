package com.f2f.dao;

import com.f2f.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("ContactDao")
@Repository
public interface ContactDao extends CrudRepository<Contact,Long> {

}
