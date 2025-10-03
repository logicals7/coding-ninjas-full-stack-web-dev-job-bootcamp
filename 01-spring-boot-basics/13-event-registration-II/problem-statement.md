# Event Registration Application Enhancement

## Problem Statement
In continuation to the Event Registration application, a new interface `College` and its implementation `MyCollege` are introduced. The application requires modifications to accommodate these changes.

---

## Tasks

1. **Complete the `MyCollege` class**:
   - Add the attribute:
     - `name` (String) initialized with a default value.

2. **Inject the `CollegeEvent` dependency**:
   - Use setter injection to inject the `CollegeEvent` dependency into the `MyCollege` class.

3. **Implement the `College` interface**:
   - Make the `MyCollege` class implement the `College` interface.
   - Override the following methods:
     - `String getCollegeName()`: Returns the college name.
     - `CollegeEvent getEvent()`: Returns the `CollegeEvent`.

4. **Update `applicationContext.xml`**:
   - Define the required beans as per the template.

5. **Modify the `main()` method**:
   - Update the `main()` method in the provided template to incorporate the new interface and its implementation.

6. **Testing**:
   - Run the `Main` class to test your implementation.

---

## Special Instructions for Submission

1. **Remove the following folders before submitting**:
   - `target` folder from the root directory.
   - `test` folder from the `src` directory.

2. **Version Requirements**:
   - Spring Boot version: `3.0.0`
   - Java version: `17`

3. **File Restrictions**:
   - Do not move the `applicationContext.xml` file.

4. **Bean Naming**:
   - The Bean ID must match the class name but in camel case (refer to the `applicationContext.xml` template).

5. **Code Integrity**:
   - Do not modify the provided template code. Changes to the template may result in incorrect output. Keeping the original code intact ensures accurate results.

---

## Notes
- Ensure all dependencies and configurations match the specified versions.
- Properly test the application before submission to ensure it meets the requirements.
