package com.cn.cnEvent.service;

import com.cn.cnEvent.dal.EventDAL;
import com.cn.cnEvent.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventDAL eventDAL;

    @Transactional
    public Event getEventById(Long id) {
        return eventDAL.getById(id);
    }

    @Transactional
    public List<Event> getAllEvents() {
        List<Event> eventList = eventDAL.getAllEvents();
        return eventList;
    }

    @Transactional
    public String saveEvent(Event event){
        return eventDAL.save(event);
    }

    @Transactional
    public String deleteEvent(Long id) {
        return eventDAL.deleteById(id);
    }

    @Transactional
    public String updateEvent(Event event) {
        return eventDAL.update(event);
    }
}
