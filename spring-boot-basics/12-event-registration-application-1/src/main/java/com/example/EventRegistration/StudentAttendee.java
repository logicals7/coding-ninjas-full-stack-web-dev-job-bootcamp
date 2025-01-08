package com.example.EventRegistration;

public class StudentAttendee implements Attendee {
	
	private String name;
	private int batch;
	private String department;
	
	@Override
	public void setAttendeeDetails(String name, String department, int batch) {
		this.name = name;
		this.department = department;
		this.batch = batch;
	}
	
	@Override
	public void printRegistrationConfirmation() {
		System.out.println("Hi " + this.name + ", your registration for the Graduation Ceremony is successful.");
	}
	
	@Override
	public String getAttendeeName() {
		return this.name;
	}

}
