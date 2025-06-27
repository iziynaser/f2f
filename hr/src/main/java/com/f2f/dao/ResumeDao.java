package com.f2f.dao;

import com.f2f.entity.Resume;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("ResumeDao")
@Repository
public interface ResumeDao extends CrudRepository<Resume,Long> {

}
