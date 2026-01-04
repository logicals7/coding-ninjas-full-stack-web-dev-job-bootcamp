package com.cn.cnEvent.controller;

import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {
	@Autowired
	EventService eventService;

	@GetMapping("/{id}")
	public Event getEventById(@PathVariable Long id)
	{
		return eventService.getEventById(id);
	}
	@GetMapping("/all")
	public List<Event> getAllEvents()
	{
		return eventService.getAllEvents();
	}

	@PostMapping("/save")
	public String saveEvent(@RequestBody Event event) {
		return eventService.saveEvent(event);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEvent(@PathVariable Long id)
	{
		return eventService.delete(id);
	}

	@PutMapping("/update")
	public String updateEvent(@RequestBody Event updateEvent)
	{
		return eventService.update(updateEvent);
	}

	//fetches the details for EventScheduleDetail class linked with the given eventId.
	@GetMapping("/eventScheduleDetail/{id}")
	public EventScheduleDetail getEventScheduleDetailInEventByEventId(@PathVariable Long id){
		return eventService.getEventScheduleDetailInEvent(id);
	}

	// It deletes the EventScheduleDetail class linked with the given eventId.
	@DeleteMapping("/delete/eventScheduleDetail/{id}")
	public String deleteEventScheduleDetail(@PathVariable Long id){
		return eventService.deleteEventScheduleDetailFromEventById(id);
	}

	//fetches the list of all Events by the given location. Note the location fetch should be case-insensitive.
	@GetMapping("/location/{location}")
	public List<Event> getEventsByLoc(@PathVariable String location){
		return eventService.getEventsByLocation(location);
	}

}
