# 🍲 Tasty Trove Recipe Finder

## 📌 Problem Statement
A developer has created the **Tasty Trove Recipe Finder**, an application that enables users to find recipes based on ingredients. However, the app is not fully optimized and is underperforming. The goal is to improve the app by implementing **IOC (Inversion of Control) and Dependency Injection using Annotations**.

## 🎯 Objective
Enhance the application by using **Spring's annotation-based configuration** to dynamically inject dependencies, making it more maintainable and scalable.

## 🚀 Features
- Users can **input their name**.
- Users can **select a recipe type** (North Indian, South Indian, or Chinese).
- Users can **select an ingredient type** (Lentils, Rice, or Wheat).
- The application **suggests a recipe** based on the selected ingredient and recipe type.

## 🏗️ Project Implementation
### ✅ Tasks to Implement
1. **Migrate from XML-based to annotation-based configuration**.
2. **Use setter-based dependency injection**.
3. **Create a new method in the `Recipe` interface**:
   ```java
   void setIngredients(String ingredients);
   ```
   - This method is responsible for setting the ingredient attribute dynamically using Dependency Injection.
   - It ensures a generic and optimized approach for multiple recipe implementations.
4. **Ensure all beans follow the camel-case naming convention** inside `@Component` annotations.

### 📌 Naming Conventions for Beans
- `NorthIndian` ➝ `northIndian`
- `SouthIndian` ➝ `southIndian`
- `Chinese` ➝ `chinese`
- `Lentils` ➝ `lentils`
- `Rice` ➝ `rice`
- `Wheat` ➝ `wheat`

## 🖥️ Application Flow
The application follows this sequence:

1️⃣ The **user starts the application**.
2️⃣ The application **prompts the user to enter their name**.
3️⃣ The application **prompts the user to select a recipe**.
4️⃣ The application **prompts the user to select an ingredient**.
5️⃣ The **recipe name and ingredients are displayed**.

### 📌 Flowchart Representation
![Application Flow](./image.png)

## 📸 Sample Output
```
Welcome to Tasty Trove Application
Enter your name?
John

Select Recipe:
1. North Indian
2. South Indian
3. Chinese
3

Select Ingredient:
1. Lentils
2. Rice
3. Wheat
2

Hello user John, we suggest you to make Chinese Fried Rice.
You can use the following ingredients:
1. Steamed Rice
2. Ginger
3. Garlic
4. Soy Sauce
5. Vinegar
```

## 📂 Project Structure
```
TastyTroveApplication/
├── src/
│   ├── main/
│   │   ├── java/com/example/TastyTrove/
│   │   │   ├── TastyTroveApplication.java
│   │   │   ├── Recipe.java
│   │   │   ├── NorthIndian.java
│   │   │   ├── SouthIndian.java
│   │   │   ├── Chinese.java
│   │   │   ├── Ingredients.java
│   │   ├── resources/
│   │   │   ├── application.properties
│   ├── test/  ❌ (Remove before submission)
├── target/ ❌ (Remove before submission)
├── pom.xml
├── README.md
```

## ⚠️ Submission Guidelines
- Remove the **`target`** folder before submission.
- Remove the **`test`** folder from the `src` directory.
- Do **NOT** modify Spring Boot (3.0.0) and Java (17) versions.
- Keep the **original template code intact** to ensure correct results.

---

## 👨‍💻 Technologies Used
- **Java 17**
- **Spring Boot 3.0.0**
- **Spring Core (IoC & DI)**
- **Maven**

Happy Coding! 🎉🍜

