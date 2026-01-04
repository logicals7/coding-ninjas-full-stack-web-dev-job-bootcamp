package com.cn.cnEvent.service;

import com.cn.cnEvent.dal.EventScheduleDetailDAL;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.exception.ElementAlreadyExistException;
import com.cn.cnEvent.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EventScheduleDetailService {
    @Autowired
    EventScheduleDetailDAL eventScheduleDetailDAL;

    @Transactional
    public EventScheduleDetail getById(Long id) {
        EventScheduleDetail esd = eventScheduleDetailDAL.getById(id);
        if(esd == null) throw new NotFoundException("No event found with id:  "+id);
        return esd;
    }

    @Transactional
    public List<EventScheduleDetail> getAll() {
        List<EventScheduleDetail> allEsd = eventScheduleDetailDAL.getAll();
        if(allEsd == null) throw new NotFoundException("No eventSceduleDetails found:  ");
        return allEsd;
    }

    @Transactional
    public String addEventScheduleDetail(EventScheduleDetail esd) {
        if (esd.getId() != null) {
            EventScheduleDetail existing = eventScheduleDetailDAL.getById(esd.getId());
            if (existing != null)
                throw new ElementAlreadyExistException("EventScheduleDetail already exists with id: " + esd.getId());
        }
        return eventScheduleDetailDAL.save(esd);
    }
}
