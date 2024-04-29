package com.f2f.dao.hr;

import com.f2f.entity.hr.WorkSheetItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("WorkSheetItemDao")
public interface WorkSheetItemDao extends CrudRepository<WorkSheetItem,Long> {

}
