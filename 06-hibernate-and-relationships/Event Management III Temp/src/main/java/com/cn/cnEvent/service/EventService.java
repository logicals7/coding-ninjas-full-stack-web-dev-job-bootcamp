package com.cn.cnEvent.service;

import com.cn.cnEvent.dal.EventDAL;
import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.exception.ElementAlreadyExistException;
import com.cn.cnEvent.exception.InvalidInputException;
import com.cn.cnEvent.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class EventService {

	@Autowired
	EventDAL eventDAL;

	@Transactional
	public Event getEventById(Long id) {
		Event event=eventDAL.getById(id);
		if(event==null){
			throw new NotFoundException("No event found with id:  "+id);
		}
		return event;
	}

	@Transactional
	public List<Event> getAllEvents() {
		List<Event> events=eventDAL.getAllEvents();
		if(events==null){
			throw new NotFoundException("No events found.");
		}
		return events;
	}

	@Transactional
	public String saveEvent(Event newEvent) {

		List<Event> allEvents  = getAllEvents();
		for(Event event : allEvents)
		{
			if(Objects.equals(event.getId(), newEvent.getId()))
			{
				throw new ElementAlreadyExistException("This event already exist.");
			}
		}
		try {
			return eventDAL.save(newEvent);
		}
		catch (Exception e)
		{
			throw new InvalidInputException("The input entity for event is invalid.");
		}
	}

	@Transactional
	public String delete(Long id) {
		List<Event> allEvents = getAllEvents();

		boolean isEntityPresent=false;
		for(Event event : allEvents)
		{
			if (Objects.equals(event.getId(), id)) {
				isEntityPresent = true;
			}
		}
		if(!isEntityPresent)
		{
			throw new InvalidInputException("This event doesn't exist.");
		}
		try{
			return eventDAL.delete(id);
		}
		catch (Exception e){
			throw new InvalidInputException("Error in deleting event.");
		}
	}
	@Transactional
	public String update(Event updateEvent) {
		try{
			return eventDAL.update(updateEvent);
		}
		catch (Exception e){
			throw new InvalidInputException("Error in deleting eventScheduleDetail from event.");
		}
	}

	//fetches the details for EventScheduleDetail class linked with the given eventId.
	@Transactional
	public EventScheduleDetail getEventScheduleDetailInEvent(Long id) {
		EventScheduleDetail esd = eventDAL.getEventScheduleDetailInEvent(id);
		if(esd==null){
			throw new NotFoundException("No event found with id:  "+id);
		}
		return esd;
	}

	// It deletes the EventScheduleDetail class linked with the given eventId.
	@Transactional
	public String deleteEventScheduleDetailFromEventById(Long id) {
		if (id == null) {
			throw new InvalidInputException("Invalid id to delete an EventScheduleDetail");
		}
		return eventDAL.deleteEventScheduleDetailFromEventById(id);
	}


	//fetches the list of all Events by the given location. Note the location fetch should be case-insensitive.
	@Transactional
	public List<Event> getEventsByLocation(String location) {
		List<Event> eventsByLoc = eventDAL.getEventsByLoc(location);
		if(eventsByLoc == null){
			throw new NotFoundException("No events found.");
		}
		return eventsByLoc;
	}
}
