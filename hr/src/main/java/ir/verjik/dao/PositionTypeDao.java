package ir.verjik.dao;

import ir.verjik.entity.PositionType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("PositionTypeDao")
@Repository
public interface PositionTypeDao extends CrudRepository<PositionType,Long> {

}
