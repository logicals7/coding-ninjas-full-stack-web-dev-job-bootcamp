package com.example.Vaccination;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class VaccinationApplication {

    public static void main(String[] args) {

        /*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.

		 Tasks:
		1. Fetch context from ApplicationContext.xml and initiate Scanner.
		2. Fetch vaccine and User type choice.
		3. Get the required bean from context.
		4. Get the appointment details form user
		5. Display the appointment details
		6. Run the loop again to book for another user or else exit.
		 */
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Vaccination Application");

        while(true){
            System.out.println("Please choose your vaccine preference:\n1. Covid\n2. Polio\n3. Typhoid");
            int vaccineChoice = sc.nextInt();
            String vaccineName = "";
            switch (vaccineChoice){
                case 1 -> vaccineName = "covid";
                case 2 -> vaccineName = "polio";
                case 3 -> vaccineName = "typhoid";
            }

            System.out.println("Whom do you want to vaccinate:\n1. Father\n2. Mother\n3. Self\n4. Spouse\n5. Exit");
            int vaccineUserChoice = sc.nextInt();
            String vaccineUser = "";
            switch (vaccineUserChoice){
                case 1 -> vaccineUser = "Father";
                case 2 -> vaccineUser = "Mother";
                case 3 -> vaccineUser = "Self";
                case 4 -> vaccineUser = "Spouse";
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
            }

            User user = (User) context.getBean(vaccineName + vaccineUser);
            boolean isVaccinated = user.IsVaccinated();
            if (isVaccinated) {
                System.out.println("User is already Vaccinated");
                System.out.println("Do you want to register for someone else\n1. Yes\n2. No");
                int next = sc.nextInt();
                if (next == 2) break;
                else continue;
            }

            sc.nextLine();
            System.out.println("Please enter " + vaccineUser + " details:");
            System.out.println("Name: ");
            String name = sc.nextLine();
            System.out.println("Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.println("Appointment date (YYYY-MM-DD): ");
            String appointmentDate = sc.nextLine();
            System.out.println("Appointment time (HH:MM AM/PM): ");
            String appointmentTime = sc.nextLine();
            System.out.println("Appointment location: ");
            String appointmentLocation = sc.nextLine();

            TimeAndLocation timeAndLocation = (TimeAndLocation) context.getBean("timeAndLocation");
            timeAndLocation.setDetails(appointmentTime, appointmentLocation, appointmentDate);

            user.setUserDetails(name, age, timeAndLocation);
            user.setAppointment();


            System.out.println("Do you want to register for someone else?\n1. Yes\n2. No");
            int nextRegistration = sc.nextInt();
            if(nextRegistration == 2){
                break;
            }


        }

    }
}