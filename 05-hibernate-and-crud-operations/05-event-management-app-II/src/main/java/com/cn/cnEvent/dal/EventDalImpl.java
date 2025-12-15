package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.Event;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class EventDalImpl implements EventDAL{

    @Autowired
    private EntityManager entityManager;

    @Override
    public Event getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Event.class, id);
    }

    @Override
    public List<Event> getAllEvents() {
        Session session = entityManager.unwrap(Session.class);
        Query<Event> query = session.createQuery("from Event", Event.class);
        return query.getResultList();
    }

    @Override
    public String save(Event item) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(item);
        session.flush();
        return "The event was saved successfully.";
    }

    @Override
    public String deleteById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Event event = session.get(Event.class, id);
        session.delete(event);
        session.flush();
        return "The event was deleted successfully";
    }

    @Override
    public String update(Event event) {
        Session session = entityManager.unwrap(Session.class);
        session.update(event);
        session.flush();
        return "Event is updated successfully";
    }

}
