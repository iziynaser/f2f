package com.f2f.service.hr;

import com.f2f.dao.hr.EventDao;
import com.f2f.entity.hr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("EventService")
public class EventService{

    @Autowired
    EventDao eventDao;

    public List<Event> findAll() {
        return (List<Event>) eventDao.findAll();
    }
}
