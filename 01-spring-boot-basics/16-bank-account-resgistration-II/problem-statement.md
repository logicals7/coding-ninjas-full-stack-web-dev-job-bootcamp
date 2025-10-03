# Bank Account Registration Application II - Bean Lifecycle Testing

## Problem Statement
In continuation of the **Bank Account Registration Application**, you must test the **bean lifecycle**.

---

## Tasks

1. **Create custom `init()` and `destroy()` methods** in the `myUser` class.

2. **Create a custom `init()` method** for `savingsAccount` and `currentAccount` classes and print your custom message in the methods.

3. **Close the context** at the end of the main application.

4. **Run and test the application**. You should be able to see the messages from the custom `init()` and `destroy()` methods on the console.

---

## Special Instructions for Submitting the Solution

1. **Remove the following folders before submission:**
   - `target` folder from the root directory of your project.
   - `test` folder from your `src` folder.

---

## Note

1. **Don't change** the versions of **Spring Boot (3.0.0)** and **Java (17)**. If needed, then install the same.

2. **Do not move** the `ApplicationContext.xml` file.

3. **Bean ID** should be the same as the class name but in **camel-case** version (refer to `ApplicationContext.xml` file).

4. **Do not modify** the template code as it may produce inaccurate results. Keeping the original code intact is crucial to ensure correct output.

---

## Sample Output

```shell
User bean has been instantiated and I'm the init() method  
Welcome to Account Registration Application!  
Please enter Your name?  
> John  

Do you want to add account  
1. Yes  
2. No  
> 1  

Please select the account type  
1. Current  
2. Savings  
> 1  

Current Account has been created I'm the init() method  
Enter the opening balance  
> 120  

Do you want to add more accounts  
1. Yes  
2. No  
> 1  

Please select the account type  
1. Current  
2. Savings  
> 2  

Savings Account has been created I'm the init() method  
Enter the opening balance  
> 230  

Do you want to add more accounts  
1. Yes  
2. No  
> 2  

Hi John, here is the list of your accounts:  
Current Account : opening balance - 120.0 Reference Id @385c9627  
Savings Account : opening balance - 230.0 Reference Id @3eb25e1a  

14:44:11.431 [main] DEBUG org.springframework.context.support.ClassPathXmlApplicationContext  
User bean has been closed and I'm the destroy() method  

Process finished with exit code 0  
