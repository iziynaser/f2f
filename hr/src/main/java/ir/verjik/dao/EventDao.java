package ir.verjik.dao;

import ir.verjik.entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("EventDao")
@Repository
public interface EventDao extends CrudRepository<Event,Long> {

}
