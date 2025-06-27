package com.f2f.dao;

import com.f2f.entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository("EventDao")
@Repository
public interface EventDao extends CrudRepository<Event,Long> {

}
