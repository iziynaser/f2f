package com.f2f.controller.hr;

import com.f2f.entity.hr.Event;
import com.f2f.service.hr.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("EventController")
@RequestMapping("/Event")
public class EventController{

    @Autowired
    EventService eventService;

    @GetMapping("/list")
    public List<Event> getEventList(){
        List<Event> list = eventService.findAll();
        return list;
    }
}
