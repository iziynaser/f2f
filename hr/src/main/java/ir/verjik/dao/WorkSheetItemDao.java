package ir.verjik.dao;

import ir.verjik.entity.WorkSheetItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
//@Repository("WorkSheetItemDao")
public interface WorkSheetItemDao extends CrudRepository<WorkSheetItem,Long> {

}
