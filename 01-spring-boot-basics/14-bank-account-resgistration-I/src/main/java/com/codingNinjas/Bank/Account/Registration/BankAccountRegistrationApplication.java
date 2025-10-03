package com.codingNinjas.Bank.Account.Registration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class BankAccountRegistrationApplication {

	public static void main(String[] args) {

		/*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.
		
		* 1. Fetch context from ApplicationContext.xml and initiate scanner.
		* 2. Get user details from console.
		* 3. Get account details from user and add them to the account list.
		* 4. Display the list of accounts with their reference ids.
		*/
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to Account Registration Application!");

		// 2. Get user details from console.
		System.out.println("Please enter your name?");
		String name = sc.nextLine();
		User myUser = (User) context.getBean("myUser");
		myUser.setUserDetails(name);

		System.out.println("Do you want to add account?\n1. Yes\n2. No");
		int addAccountChoice = sc.nextInt();

		if (addAccountChoice != 1) {
			return;
		}

		// 3. Get account details from user and add them to the account list.
		boolean addMoreAccounts = true;

		while (addMoreAccounts) {

			System.out.println("Please select the account type:\n1. Current\n2. Savings");
			int accountTypeChoice = sc.nextInt();

			System.out.println("Enter the opening balance");
			double balance = sc.nextDouble();

			Account account;

			if (accountTypeChoice == 1) {
				account = (Account) context.getBean("currentAccount");
			} else {
				account = (Account) context.getBean("savingsAccount");
			}

			account.addBalance(balance);
			myUser.addAccount(account);

			System.out.println("Do you want to add more accounts?\n1. Yes\n2. No");
			int resumeChoice = sc.nextInt();
			if (resumeChoice != 1) {
				addMoreAccounts = false;
			}
		}

		// 4. Display the list of accounts with their reference ids.
		System.out.println("Hi " + myUser.getName() + ", here is the list of your accounts:");
		for (Account acc : myUser.getAllAccounts()) {
			System.out.println(acc.getAccountType() + " Account : opening balance - " + acc.getBalance() + " Reference Id " + acc);
		}
	}
}
