# CodeAlpha_StudentGradeTracker

## Project Purpose
The **Student Grade Tracker** is a Java console-based application designed to help teachers or administrators manage student grades efficiently. It allows adding students, viewing records, searching by roll number, and calculating class statistics. This project was built for the CodeAlpha internship program.

## Features
- **Add a Student:** Input student name, roll number, and marks (0-100).
- **View All Students:** Displays the complete list of students along with their corresponding grades.
- **Search Student:** Find a specific student using their roll number.
- **Calculate Statistics:** Computes and displays the class average, highest marks, and lowest marks.
- **File Handling:** Automatically saves student records to a local text file (`students.txt`) and loads them back when the program restarts. No data is lost between sessions.
- **Validation:** Handles invalid menu choices, ensures marks are between 0 and 100, and prevents program crashes due to invalid input types.

## Technologies Used
- **Language:** Java (JDK 8 or higher)
- **Concepts Used:** Object-Oriented Programming (OOP), File I/O, Exception Handling, Collections (`ArrayList`), Input Validation.

## Project Structure
```text
CodeAlpha_StudentGradeTracker/
│
├── src/
│   ├── Main.java                # The entry point of the application handling the user interface menu.
│   ├── Student.java             # The Student class representing individual student data.
│   └── StudentGradeTracker.java # The logic class that manages the list of students and file operations.
│
├── students.txt                 # Data file created automatically to store student records.
└── README.md                    # Project documentation.
```

## How to Run the Project
1. Open a terminal or command prompt.
2. Navigate to the `src` folder inside the project directory:
   ```bash
   cd path/to/CodeAlpha_StudentGradeTracker/src
   ```
3. Compile the Java files:
   ```bash
   javac Main.java Student.java StudentGradeTracker.java
   ```
4. Run the application:
   ```bash
   java Main
   ```

## Example Output
```text
===== Student Grade Tracker =====
1. Add Student
2. View All Students
3. Search Student
4. Calculate Statistics
5. Exit
Enter your choice: 1
Enter Student Name: John Doe
Enter Roll Number: 101
Enter Marks (0-100): 85
Student added successfully!

===== Student Grade Tracker =====
1. Add Student
2. View All Students
3. Search Student
4. Calculate Statistics
5. Exit
Enter your choice: 4

===== Class Statistics =====
Total Students: 1
Average Marks: 85.00
Highest Marks: 85.0
Lowest Marks: 85.0
============================
```
