package ir.verjik.service;

import ir.verjik.dao.EventDao;
import ir.verjik.entity.Event;
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
