package ir.verjik.dao;

import ir.verjik.entity.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("HolidayDao")
@Repository
public interface HolidayDao extends CrudRepository<Holiday,Long> {

}
