package com.f2f.dao.hr;

import com.f2f.entity.hr.WorkSheet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("WorkSheetDao")
public interface WorkSheetDao extends CrudRepository<WorkSheet,Long> {

}
