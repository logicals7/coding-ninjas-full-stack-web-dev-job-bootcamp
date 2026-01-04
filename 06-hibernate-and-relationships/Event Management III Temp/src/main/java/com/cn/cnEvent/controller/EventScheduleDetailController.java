package com.cn.cnEvent.controller;

import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.service.EventScheduleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventScheduleDetail")
public class EventScheduleDetailController {

    @Autowired
    EventScheduleDetailService eventScheduleDetailService;

    //fetches an EventScheduleDetail entity with the given id
    @GetMapping("/{id}")
    public EventScheduleDetail getEventScheduleDetail(@PathVariable Long id){
        return eventScheduleDetailService.getById(id);
    }

    //fetches the list of all EventScheduleDetail from the database.
    @GetMapping("/all")
    public List<EventScheduleDetail> getAllEventScheduleDetail(){
        return eventScheduleDetailService.getAll();
    }


    //saves an EventScheduleDetail entity and returns a message in string format "saved successfully".
    @PostMapping("/save")
    public String addEventScheduleDetail(@RequestBody EventScheduleDetail event){
        return eventScheduleDetailService.addEventScheduleDetail(event);
    }


}
