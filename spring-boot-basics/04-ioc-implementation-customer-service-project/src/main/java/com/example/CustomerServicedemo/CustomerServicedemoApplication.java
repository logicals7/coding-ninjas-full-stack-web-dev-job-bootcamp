package com.example.CustomerServicedemo;

import com.example.Customers.CustomerCare;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class CustomerServicedemoApplication {

	public static void main(String[] args) {

		/*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.

			 Tasks:
		 *  1. Load the beans from ApplicationContext.xml
		 *  2. Display all the departments available and get the input from user.
		 *  3. Get the message from user and store it into the respective department.
		 *  
		 */

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to our Customer Care application");
		System.out.println("Please enter your name: ");
		String name = sc.nextLine();
		System.out.println("Please select a department to connect to: \n1. Payment Department\n2. Query Department\n3. Sales Department\n0. Exit");
		int deptChoice = sc.nextInt();
		sc.nextLine();
		String deptName = "";
		switch(deptChoice){
			case 1 ->
				deptName = "paymentDepartment";
			case 2 ->
				deptName = "queryDepartment";
			case 3 ->
				deptName = "salesDepartment";
            default -> {
                return;
            }
        }

		CustomerCare dept = (CustomerCare) context.getBean(deptName);
		dept.setCustomerName(name);
		dept.getService();
		String issue = sc.nextLine();
		dept.setProblem(issue);
		dept.getProblem();
	}
}
