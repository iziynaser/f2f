package com.f2f.dao;

import com.f2f.entity.WorkSheetItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
//@Repository("WorkSheetItemDao")
public interface WorkSheetItemDao extends CrudRepository<WorkSheetItem,Long> {

}
