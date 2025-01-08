package com.example.EventRegistration;

import java.util.ArrayList;
import java.util.List;

public class GraduationCeremonyEvent implements CollegeEvent {

    /*
    1. Create the following attributes:
        a. name (initialize it as "Graduation Ceremony".
        b. address (String)
        c. time (String)
        d. date (String)
        e. count (int) (initially 0)
        f. eventAttendees (List of Attendee)
        NOTE: Initialize the address, time and date attributes with some values.
    2. Inject Attendee with attribute name "attendee" with setter injection.
    3. Make this class an implementation of CollegeEvent interface and override the interface methods.
    */
	private String name = "Graduation Ceremony";
	private String address = "Amphitheatre";
	private String time = "12 PM";
	private String date = "January 15, 2025";
	private int count = 0;
	private List<Attendee> eventAttendees;
	
	//injects the Attendee bean
	private Attendee attendee;
	
	//initializes the list of attendees through constructor
	public GraduationCeremonyEvent() {
		this.eventAttendees = new ArrayList<>();
	}
	
	@Override
	public void registerStudent(Attendee user) {
		this.eventAttendees.add(user);
		count++;
	}

	@Override
	public List<Attendee> getAllAttendees() {
		return this.eventAttendees;
	}

	@Override
	public void printEventDetails() {
		System.out.println("The Graduation Ceremony details are as follows:");
        System.out.println("• Venue: " + this.address);
        System.out.println("• Time: " + this.time);
        System.out.println("• Date: " + this.date);
	}

	@Override
	public int getAttendeeCount() {
		return count;
	}
	
	//injects the Attendee Bean
	@Override
	public void setAttendee(Attendee attendee) {
		this.attendee = attendee;
	}
	
	
	

}
