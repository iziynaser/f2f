package com.f2f.dao;

import com.f2f.entity.common.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("SubjectDao")
public interface SubjectDao extends CrudRepository<Subject,Long>{

}
