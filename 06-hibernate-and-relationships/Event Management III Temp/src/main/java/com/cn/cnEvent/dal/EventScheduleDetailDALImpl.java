package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.EventScheduleDetail;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EventScheduleDetailDALImpl implements EventScheduleDetailDAL{

    @Autowired
    EntityManager entityManager;

    @Override
    public EventScheduleDetail getById(Long id){
        Session session = entityManager.unwrap(Session.class);
        return session.get(EventScheduleDetail.class, id);
    }

    @Override
    public List<EventScheduleDetail> getAll(){
        Session session = entityManager.unwrap(Session.class);
        List<EventScheduleDetail> ls = session.createQuery("from EventScheduleDetail", EventScheduleDetail.class).getResultList();
        return ls;
    }

    @Override
    public String save(EventScheduleDetail details){
        Session session = entityManager.unwrap(Session.class);
        session.save(details);
        return "saved successfully";
    }
}
