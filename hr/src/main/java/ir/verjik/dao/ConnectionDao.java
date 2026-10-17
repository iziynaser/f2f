package ir.verjik.dao;

import ir.verjik.entity.Connection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("ConnectionDao")
@Repository
public interface ConnectionDao extends CrudRepository<Connection,Long> {

}
