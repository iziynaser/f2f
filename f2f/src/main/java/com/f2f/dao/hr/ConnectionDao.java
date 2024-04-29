package com.f2f.dao.hr;

import com.f2f.entity.hr.Connection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("ConnectionDao")
public interface ConnectionDao extends CrudRepository<Connection,Long> {

}
