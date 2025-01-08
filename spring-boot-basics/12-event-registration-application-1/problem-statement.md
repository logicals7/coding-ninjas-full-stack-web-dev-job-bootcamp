#Problem statement:
Suppose you are creating an Event Registration Application for a Graduation Ceremony happening in your college. Complete the console application using the concepts of dependency injection and bean scope.

In the application, attendees can register for the ceremony and see the list of all attendees.

#Tasks:-
1. Complete the StudentAttendee class with the following attributes:
    • name (String)
    • batch (int)
    • department (String)

2. Make the StudentAttendee class implement the Attendee interface and override the interface methods.

3. The Attendee interface has the following methods:
    a. void setAttendeeDetails(String name, String department, int batch): This method sets the details of the Attendee.
    b. void printRegistrationConfirmation(): This method prints the Registration ConfirmationFor example, if the Attendee's name is John, the confirmation statement is as follows: Hi John, your registration for the Graduation Ceremony is successful.
    c. String getAttendeeName(): This method returns the Attendee's name.

4. Complete the GraduationCeremonyEvent class with the following attributes:
    • name (initialize it as "Graduation Ceremony")
    • address (String)
    • time (String)
    • date (String)
    • count (int) (initially 0)
    • eventAttendees (List of Attendee)

    NOTE: Initialize the address, time and date attributes with some values.
    
5. Inject Attendee with attribute name "attendee" with setter injection in the GraduationCeremonyEvent class.
6. Make the GraduationCeremonyEvent class implement the CollegeEvent interface and override the interface methods.

7. The CollegeEvent interface has the following methods:
    a. void registerStudent(Attendee user): This method registers the attendee for the ceremony, i.e. it adds the attendee to the eventAttendees list and increases the AttendeeCount attribute, which is the count of attendee attending the event.
    b. List getAllAttendees(): This method returns the list of attendees.
    
    c. void printEventDetails(): This method prints the event details. For example:
    "The Graduation Ceremony details are as follows:
    • Venue: Auditorium
    • Time: 10 AM
    • Date: 12 Nov 2023"
    
    d. int getAttendeeCount(): This method returns the attendeeCount.
    e. void setAttendee(Attendee attendee): This method sets the attendee.
    
8. Create the beans in the applicationContext.xml file as described in the template.
9. Complete the logic given in the main() method in the template.
10. Test your implementation by running the Main class.


#Special Instructions for submitting the solution:
    1. Remove the target folder from the root directory of your project.
    2. Remove the "test" folder from your "src" folder.
    
    
#Note:-
    1. Don't change the versions of spring-boot (3.0.0) and Java (17). If needed then install the same.
    2. Do not move the "ApplicationContext" file.
    3. Bean ID should be the same as the class name but in camel-case version(refer to ApplicationContext file).
    4. Do not modify the template code as it may produce inaccurate results. Keeping the original code intact is crucial to ensure correct output.

#Sample output:-





