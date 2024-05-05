package com.f2f.dao.hr;

import com.f2f.entity.hr.Resume;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("ResumeDao")
public interface ResumeDao extends CrudRepository<Resume,Long> {

}
