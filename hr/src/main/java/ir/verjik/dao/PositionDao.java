package ir.verjik.dao;

import ir.verjik.entity.Position;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("PositionDao")
@Repository
public interface PositionDao extends CrudRepository<Position,Long> {

}
