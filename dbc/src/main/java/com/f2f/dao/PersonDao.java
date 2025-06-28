package com.f2f.dao;

import com.f2f.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("PersonDao")
@Repository
public interface PersonDao extends JpaRepository<PersonEntity,Long> {

}
