# TuneIn - Optimized Playlist Application

## 📌 Overview
TuneIn is a music playlist application that enables users to create and manage playlists efficiently. The application is being optimized by implementing **Inversion of Control (IOC)**, **Dependency Injection**, and **Bean Scope** using Spring Boot annotations.

---

## 🎯 Objective
The primary goal is to refactor the existing application by:
- Implementing **IOC** for better modularity.
- Using **Dependency Injection** for managing dependencies.
- Defining **Bean Scopes** properly.
- Maintaining **Spring Boot (3.0.0)** and **Java (17)** compatibility.

---

## 🛠️ Technical Implementation
### ✅ Bean Naming Convention
Use **camel-case** naming convention for defining bean names inside `@Component` annotation.

**Example:**
```java
@Component("mySong")
public class MySong {
    // Class Implementation
}
```

### ✅ Application Flow (Based on Flowchart)
1. **User starts the application**
2. The application prompts the user to enter their **name and age**.
3. The user is **asked if they want to add songs**.
4. If **Yes**, the user enters the song name and repeats the process.
5. If **No**, the **playlist with reference ID** and **song details** are displayed.

---

## 🖥️ Sample Output
```
Welcome to Music Playlist Application
What is your name?
Virat
What is your age?
34

Do you want to add Songs to the playlist
1. Yes
2. No
1

Enter name of the song
Closer

Do you want to add Songs to the playlist
1. Yes
2. No
1

Enter name of the song
Perfect

Do you want to add Songs to the playlist
1. Yes
2. No
2

Your Playlist with reference Id: @c730b35 is Ready!!
Song name: Closer    Reference Id: @206a70ef
Song name: Perfect   Reference Id: @292b08d6
```

---

## 🚀 Special Instructions
### ✅ Before Submission:
- Remove the `target` folder from the root directory.
- Remove the `test` folder from the `src` folder.

### ✅ Version Compliance:
- **Spring Boot:** `3.0.0`
- **Java:** `17`

> ⚠️ Do **NOT** modify the template code as it may produce inaccurate results.

---

## 📂 File Structure
```
TuneIn-Project/
│── src/
│   ├── main/
│   │   ├── java/com/tunein/
│   │   │   ├── config/
│   │   │   ├── model/
│   │   │   ├── service/
│   │   │   ├── controller/
│   ├── resources/
│── target/ ❌ (Remove before submission)
│── test/ ❌ (Remove before submission)
│── image.png (Flowchart)
│── README.md
```

---

## 🎵 Happy Coding! 🎶