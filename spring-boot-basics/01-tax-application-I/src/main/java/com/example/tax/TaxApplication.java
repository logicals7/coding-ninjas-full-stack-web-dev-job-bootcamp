package com.example.tax;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class TaxApplication {

	public static void main(String[] args) {
		// Take ClassPathXmlApplicationContext from applicationContext.xml file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the tax type: ");
		String taxType = sc.nextLine();

		System.out.println("Enter the taxable amount: ");
		int taxableAmount = sc.nextInt();

		if(taxType.equals("income")){
			Tax incomeTax = (Tax) context.getBean("incomeTax");
			incomeTax.setTaxableAmount(taxableAmount);
			incomeTax.calculateTaxAmount();
			System.out.println("Total income tax: " + incomeTax.getTaxAmount());
			incomeTax.payTax();
		}
		else {
			Tax propertyTax = (Tax) context.getBean("propertyTax");
			propertyTax.setTaxableAmount(taxableAmount);
			propertyTax.getTaxType();
			propertyTax.calculateTaxAmount();
			System.out.println("Total property tax: " + propertyTax.getTaxAmount());
			propertyTax.payTax();
		}
	}

}
