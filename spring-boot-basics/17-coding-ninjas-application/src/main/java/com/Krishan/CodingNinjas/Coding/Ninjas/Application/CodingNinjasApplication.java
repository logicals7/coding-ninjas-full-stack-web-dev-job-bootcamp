package com.Krishan.CodingNinjas.Coding.Ninjas.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Scanner;

//@SpringBootApplication
//the purpose of this exercise is to understand - how we can replace the applicationContext.xml file using spring based annotations
public class CodingNinjasApplication {

	public static void main(String[] args) {

		//IOC

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.Krishan.CodingNinjas.Coding.Ninjas.Application");
		Scanner sc = new Scanner(System.in);
		//get the user prototype bean and set details
		User user = context.getBean(User.class);
		System.out.println("Please enter your name");
		String name = sc.nextLine();
		System.out.println("Please enter your age");
		String age = sc.nextLine();
		System.out.println("Please enter your college");
		String college = sc.nextLine();
		System.out.println("Please enter your location");
		String location = sc.nextLine();
		user.setUserDetails(name, age, location, college);
		System.out.println(user.getUserDetails());

		Instructor javaInstructor = context.getBean(JavaInstructor.class);
		javaInstructor.setInstructorDetails("Rahul Mohan", "26");
		System.out.println(javaInstructor.takeClass());

		//DI
		PaidCourse paidCourse = context.getBean(PaidCourse.class);
		paidCourse.setCourseDetail("This is a test course.");
		System.out.println(paidCourse.getCourseName());





		/**
		 *      //ApplicationContext.xml based application
		 *
		 * 		System.out.println("Welcome to the coding ninjas app");
		 * 		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 *
		 * 		//configure the course and create a list of courses offered
		 * 		ArrayList<PaidCourse> paidCourses = new ArrayList<PaidCourse>();
		 * 		PaidCourse javaCourse = (PaidCourse) context.getBean("javaCourse");
		 * 		PaidCourse springCourse = (PaidCourse) context.getBean("springCourse");
		 *
		 * 		//set java course instructor details & course name
		 * 		javaCourse.courseInstructor.setInstructorDetails("KK", "26");
		 * 		javaCourse.setCourseDetail("Basics of Java");
		 * 		//set spring course instructor details & course name
		 * 		springCourse.courseInstructor.setInstructorDetails("Krishan", "26");
		 * 		springCourse.setCourseDetail("Basics of Spring");
		 *
		 * 		//add the java & spring course to the list of paid courses
		 * 		paidCourses.add(javaCourse);
		 * 		paidCourses.add(springCourse);
		 *
		 * 		Scanner sc = new Scanner(System.in);
		 *
		 * 		while(true){
		 * 			System.out.println("--------XXXXX--------");
		 * 			System.out.println("Please select from the following: \n1. Register a new user\n2. See course information\n3.To quit");
		 * 			int option = sc.nextInt();
		 * 			sc.nextLine(); //flush scanner
		 *
		 * 			switch(option){
		 * 				case 1: {
		 * 					//get the user prototype bean and set details
		 * 					User user = (User) context.getBean("simpleUser");
		 * 					System.out.println("Please enter your name");
		 * 					String name = sc.nextLine();
		 * 					System.out.println("Please enter your age");
		 * 					String age = sc.nextLine();
		 * 					System.out.println("Please enter your college");
		 * 					String college = sc.nextLine();
		 * 					System.out.println("Please enter your location");
		 * 					String location = sc.nextLine();
		 * 					user.setUserDetails(name, age, location, college);
		 *
		 * 					//select the course for the list of paid courses we have configured
		 * 					int index = 0;
		 * 					System.out.println("Please select a course");
		 * 					for(Course course : paidCourses){
		 * 						System.out.println(index + ")" + course.getCourseName());
		 * 						index++;
		 * 					                    }
		 * 					int courseId = sc.nextInt();
		 * 					if (courseId >= paidCourses.size()){
		 * 						System.out.println("Not a valid course");
		 * 						break;
		 *                    }
		 * 					//get the selected couse
		 * 					PaidCourse selectedCourse = paidCourses.get(courseId);
		 * 					//add user to the userList of the course
		 * 					selectedCourse.userList.addUser(user);
		 * 					break;                * 				}
		 *
		 * 				case 2: {
		 * 					//display details of the paidCourses
		 * 					for(Course course: paidCourses){
		 * 						System.out.println("------XXXXX-------");
		 * 						System.out.println(course.getCourseName());
		 * 						if(course.getUserList().getUserList().size() > 0){
		 * 							int index = 1;
		 * 							for(User user : course.getUserList().getUserList()){
		 * 								System.out.println(index + ")" + user.getUserDetails());
		 * 								index++;
		 *                            }
		 *                        }
		 * 						else{
		 * 							System.out.println("No students registered for the course");
		 *                        }                    * 					}
		 * 					break;
		 * 				}
		 *
		 * 				case 3: {
		 * 					break;
		 * 				}
		 *
		 * 				default:
		 * 					throw new IllegalArgumentException("Unexpected value: " + option);
		 * 			}
		 * 			if(option == 3){
		 * 				break;
		 * 			        }
		 * 		}
		 * 		System.out.println("program stopped");
		 * 		sc.close();
		 * 		context.close();
		 *
		 */


		//SpringApplication.run(CodingNinjasApplication.class, args);
	}

}
