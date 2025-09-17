# 🎓 Student Registration System 📚

A simple Java-based student course registration system that allows students to add and drop courses with conflict detection! ✨

## 📁 Project Structure

- `mainTest.java` 🚀 - Main application with interactive menu
- `student.java` 👨‍🎓 - Student class with course management
- `course.java` 📖 - Course class with scheduling information

## 🔧 Features

- ✅ View all available courses
- 👥 Display student information and enrolled courses
- ➕ Add courses to student schedules
- ❌ Remove courses from student schedules
- ⚠️ Time conflict detection (prevents overlapping classes)
- 📊 Enrollment limits (max 5 students per course, max 5 courses per student)

## 🏫 Sample Data

The system comes pre-loaded with:
- **10 courses** including Programming, Database, Web Design, Statistics, and more
- **10 students** with unique student IDs

## 🚀 How to Run

```bash
# Compile the project
javac MyProjects/studentRegister/*.java

# Run the main application
java MyProjects.studentRegister.mainTest
```

## 📋 Menu Options

1. **Course List** 📖 - View all available courses
2. **Student Information** 👨‍🎓 - See student details and enrolled courses
3. **Add Course** ➕ - Enroll a student in a course
4. **Drop Course** ❌ - Remove a course from student's schedule
5. **Exit** 🚪 - Close the application

## 🛡️ System Rules

- Maximum **5 courses** per student
- Maximum **5 students** per course
- No time conflicts allowed (courses can't overlap)
- Each course is 3 hours long

## 💻 Technologies Used

- Java ☕
- Object-Oriented Programming principles
- ArrayList for data management
- Scanner for user input

Perfect for learning Java OOP concepts and building simple management systems! 🌟
