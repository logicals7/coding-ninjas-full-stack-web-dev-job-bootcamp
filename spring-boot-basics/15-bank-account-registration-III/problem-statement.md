# Event Registration Application - Bean Lifecycle Implementation  

## **Problem Statement**  
In continuation of the **Event Registration Application**, you must now implement **bean lifecycle methods** for the beans in the application. This involves defining custom initialization and destruction methods to manage bean lifecycle events effectively.  

---

## **Features & Tasks**  

### 1. Implement **Custom Lifecycle Methods**  
- Define **init()** and **destroy()** methods in:  
  - `MyCollege`  
  - `GraduationCeremonyEvent`  

- Define a **custom init()** method in:  
  - `StudentAttendee`  

### 2. Modify `applicationContext.xml`  
- Ensure the lifecycle methods are correctly configured in **`applicationContext.xml`**.  

### 3. Close the Application Context  
- Properly **close the Spring context** in the `main()` method to trigger the destroy methods.  

### 4. Test the Application  
- Run the `Main` class to verify that lifecycle methods are executed correctly.  

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
   - Follow **camel-case** for bean IDs (e.g., `myCollege`, `graduationCeremonyEvent`).  

4. **Code Integrity:**  
   - **Do not modify** the provided template code. Keeping the original code intact ensures accurate results.  

---

## **Expected Console Output**  

```shell
Initializing MyCollege bean...  
Initializing GraduationCeremonyEvent bean...  
Initializing StudentAttendee bean...  

Welcome to the Event Registration Application  
Graduation Ceremony Event is scheduled.  

Destroying MyCollege bean...  
Destroying GraduationCeremonyEvent bean...  
Closing the Spring Context.  
