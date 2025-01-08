package com.example.EventRegistration;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class EventRegistrationApplication {

	public static void main(String[] args) {
		// Import scanner and take ClassPathXmlApplicationContext.
		Scanner scanner = new Scanner(System.in);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		System.out.println("Welcome to the Graduation Ceremony Registration Application");
		// Take the college event bean from the application context.
		CollegeEvent event = (CollegeEvent) context.getBean("event");
		// Print the event details.
		event.printEventDetails();

		while (true) {
			System.out.println("Do you want to register for the ceremony\n1. Yes\n2. No");
			int input = scanner.nextInt();
			//scanner.nextLine();
			if (input == 1) {
				/*
				 1. Take attendee details from the console.
				 2. Get studentAttendee bean from context and set the attendee details
				 3. Register the attendee for the event.
				 4. Print the registration confirmation.
				 */
				System.out.println("Enter your name:");
                String name = scanner.nextLine();
                System.out.println("Enter your department:");
                String department = scanner.nextLine();
                System.out.println("Enter your batch:");
                int batch = scanner.nextInt();
                //scanner.nextLine();
                
                Attendee attendee = context.getBean("student", Attendee.class);
                attendee.setAttendeeDetails(name, department, batch);
                
                event.registerStudent(attendee);
                attendee.printRegistrationConfirmation();
			} else if(input == 2) {
				break;
			} else {
				System.out.println("Invalid Choice");
				return;
			}
		}

		// Get the number of attendees and print along with the statement below
		System.out.println("No. of attendees registered are: " + event.getAttendeeCount());

        // Print all the attendee names with their reference ids as given in the sample output..
        System.out.println("The list of attendees are:");
        for (Attendee attendee : event.getAllAttendees()) {
            System.out.println(attendee.getAttendeeName() + "          Reference Id: @" + Integer.toHexString(attendee.hashCode()));
        }
	}

}
