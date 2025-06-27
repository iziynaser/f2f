package com.f2f.dao;

import com.f2f.entity.WorkSheet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("WorkSheetDao")
@Repository
public interface WorkSheetDao extends CrudRepository<WorkSheet,Long> {

}
