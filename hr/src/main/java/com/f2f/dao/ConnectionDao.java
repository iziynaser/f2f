package com.f2f.dao;

import com.f2f.entity.Connection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("ConnectionDao")
@Repository
public interface ConnectionDao extends CrudRepository<Connection,Long> {

}
