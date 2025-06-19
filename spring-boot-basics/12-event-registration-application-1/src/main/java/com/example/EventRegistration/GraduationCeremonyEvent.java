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

    String name;
    String address;
    String time;
    String date;
    int count;
    List<Attendee> eventAttendees;
    Attendee user;

    public GraduationCeremonyEvent() {
        this.name = "Graduation Ceremony";
        this.count = 0;
        this.address = "Delhi";
        this.time = "12:00 PM";
        this.date = "January 1, 2026";
        this.eventAttendees = new ArrayList<>();
    }

    @Override
    public void registerStudent(Attendee user) {
        eventAttendees.add(user);
        count++;
    }

    @Override
    public List<Attendee> getAllAttendees() {
        return eventAttendees;
    }

    @Override
    public void printEventDetails() {
        System.out.println("The graduation ceremony details are as follows:");
        System.out.println("Venue: " + this.address);
        System.out.println("Time: " + this.time);
        System.out.println("Date: " + this.date);
    }

    @Override
    public int getAttendeeCount() {
        return count;
    }

    @Override
    public void setAttendee(Attendee attendee) {
        this.user = attendee;
    }
}
