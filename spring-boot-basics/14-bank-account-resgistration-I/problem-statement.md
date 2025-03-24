# Bank Account Registration Application  

## Problem Statement  
A developer is building a **Bank Account Registration Application** using **Spring Boot** and **dependency injection**. This application allows users to register and create multiple bank accounts (Current and Savings). The goal is to complete the console-based application by implementing the required classes and ensuring accounts are managed correctly.  

---

## Features & Tasks  

### 1. Implement the `myUser` Class (User Interface Implementation)  
#### **Attributes:**  
- `String name`  
- `List<Account> accountList`  

#### **Methods:**  
- `void setUserDetails(String name)`: Sets the user’s name.  
- `void addAccount(Account account)`: Adds an account to the account list.  
- `List<Account> getAllAccounts()`: Returns the list of all accounts.  
- `String getName()`: Retrieves the user’s name.  

### 2. Implement the `currentAccount` and `savingsAccount` Classes (Account Interface Implementation)  
#### **Attribute:**  
- `double amount` (Account balance)  

#### **Methods:**  
- `String getAccountType()`: Returns account type as **"Current Account"** or **"Savings Account"**.  
- `void addBalance(double balance)`: Adds balance to the account.  
- `double getBalance()`: Returns the current balance.  

### 3. Configure Beans in `applicationContext.xml`  
- Define a **singleton-scoped** bean for `myUser`.  
- Define **prototype-scoped** beans for `currentAccount` and `savingsAccount`.  

### 4. Modify the `main()` Method  
- Load the **ApplicationContext.xml**.  
- Allow users to **register**, **create accounts**, and **list them**.  
- Ensure **each account object reference is unique**, proving correct bean instantiation.  

---

## **Guidelines for Submission**  
1. **Remove the following folders before submission:**  
   - `target` folder from the root directory.  
   - `test` folder inside `src`.  

2. **Do Not Change the Following:**  
   - **Spring Boot version** (`3.0.0`)  
   - **Java version** (`17`)  
   - **ApplicationContext.xml location**  

3. **Bean Naming Convention:**  
   - Follow **camel-case** for bean IDs (e.g., `currentAccount` instead of `CurrentAccount`).  

4. **Code Integrity:**  
   - **Do not modify** the provided template code. Keeping the original code intact ensures accurate results.  

---

## **Expected Console Output**  

```shell
Welcome to Account Registration Application  
Please enter your name?  
> John Doe  

Do you want to add an account?  
1. Yes  
2. No  
> 1  

Please select the account type:  
1. Current  
2. Savings  
> 1  

Enter the opening balance:  
> 5000  

Do you want to add another account?  
1. Yes  
2. No  
> 2  

Hi John Doe, here is the list of your accounts:  
Current Account : opening balance - 5000.0 (Account Reference: com.codingNinjas.Bank.Account.Registration.currentAccount@3e3abc88)  
