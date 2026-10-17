package ir.verjik.dao;

import ir.verjik.entity.WorkSheet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("WorkSheetDao")
@Repository
public interface WorkSheetDao extends CrudRepository<WorkSheet,Long> {

}
