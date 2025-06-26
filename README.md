# 🎓 Student Dashboard – Java + PostgreSQL Project

A simple Student Dashboard system built with **Java**, **JDBC**, and **PostgreSQL** to manage student records like add, update, view, and delete.

---

## 🛠️ Technologies Used
- Java
- JDBC
- PostgreSQL
- IntelliJ IDEA

---

## 💡 Features
- ✅ Add Student
- ✅ View All Students
- ✅ View Student by Roll Number
- ✅ Update Student Details
- ✅ Delete Student Record

---

## 🗂️ Project Structure

src/
├── DBConnection.java
├── Student.java
├── StudentDAO.java
├── StudentDashboard.java
└── Main.java

yaml
Copy
Edit

---

## 🧪 How to Run

1. Create a PostgreSQL database: `student_dashboard`

2. Run this SQL query:
   
```sql
CREATE TABLE students(
  id SERIAL PRIMARY KEY,
  name VARCHAR(20) NOT NULL,
  roll_no VARCHAR(20) NOT NULL,
  branch VARCHAR(30) NOT NULL,
  email VARCHAR(48) NOT NULL,
  marks NUMERIC(5) NOT NULL
);
4.Open the project in IntelliJ IDEA

5.Update your PostgreSQL username and password in DBConnection.java

6.Run Main.java → and use the menu to manage students!

