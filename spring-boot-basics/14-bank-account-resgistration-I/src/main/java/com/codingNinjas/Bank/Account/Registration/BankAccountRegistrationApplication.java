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
		Scanner scanner = new Scanner(System.in);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		myUser user = context.getBean("myUser", myUser.class);

		System.out.println("Welcome to Account Registration Application");
		System.out.println("Please enter your name?");
		String name = scanner.nextLine();
		user.setUserDetails(name);

		System.out.println("Do you want to add account? \n1. Yes\n2. No");
		int addAccountChoice = scanner.nextInt();

		if (addAccountChoice == 1){
			while(true){
				System.out.println("Please select the account type\n1. Current\n2. Savings");
				int accountType = scanner.nextInt();
				System.out.println("Enter the opening balance");
				double balance = scanner.nextDouble();

				Account account = null;
				if(accountType == 1)
					account = context.getBean("currentAccount", currentAccount.class);
				else
					account = context.getBean("savingsAccount", savingsAccount.class);

				if(account != null) {
					account.addBalance(balance);
					user.addAccount(account);
				}

				System.out.println("Do you want to add more accounts? \n1. Yes\n2. No");
				int addMoreAccountsChoice = scanner.nextInt();
				if(addMoreAccountsChoice == 1) continue;
				else break;
			}
		}
		//this executes if the choice is 2 & shows no accounts
		//also executes to show the list of all accounts for a user
		System.out.println("Hi " + user.name + ", here is the list of your accounts: ");
		for(Account account : user.getAllAccounts()){
			//System.out.println(i.getAccountType() + " : opening balance - " + i.getBalance() + );
			System.out.println(account.getAccountType() + " : opening balance - " + account.getBalance() +
					" Reference Id " + account);

		}








	}

}
