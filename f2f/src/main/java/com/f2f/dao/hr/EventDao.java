package com.f2f.dao.hr;

import com.f2f.entity.hr.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("EventDao")
public interface EventDao extends CrudRepository<Event,Long> {

}
