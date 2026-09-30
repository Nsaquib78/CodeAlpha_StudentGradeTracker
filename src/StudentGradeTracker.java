import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    private ArrayList<Student> students;
    private static final String FILE_NAME = "students.txt";

    public StudentGradeTracker() {
        students = new ArrayList<>();
        loadStudentsFromFile(); // Load existing data when the program starts
    }

    // Check if a roll number already exists
    public boolean isRollNumberExists(String rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber().equalsIgnoreCase(rollNumber)) {
                return true;
            }
        }
        return false;
    }

    // Add a new student and save to the file
    public void addStudent(Student student) {
        students.add(student);
        saveStudentsToFile();
    }

    // View all students in the list
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Search for a student by roll number
    public void searchStudent(String rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber().equalsIgnoreCase(rollNumber)) {
                System.out.println("Student found:");
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    // Calculate and display average, highest, and lowest marks
    public void calculateStatistics() {
        if (students.isEmpty()) {
            System.out.println("No students available to calculate statistics.");
            return;
        }

        double totalMarks = 0;
        double highest = students.get(0).getMarks();
        double lowest = students.get(0).getMarks();

        for (Student student : students) {
            double marks = student.getMarks();
            totalMarks += marks;
            
            if (marks > highest) {
                highest = marks;
            }
            if (marks < lowest) {
                lowest = marks;
            }
        }

        double average = totalMarks / students.size();

        System.out.println("\n===== Class Statistics =====");
        System.out.println("Total Students: " + students.size());
        System.out.printf("Average Marks: %.2f\n", average);
        System.out.println("Highest Marks: " + highest);
        System.out.println("Lowest Marks: " + lowest);
        System.out.println("============================");
    }

    // Save student records to a text file
    private void saveStudentsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student student : students) {
                writer.println(student.toFileFormat());
            }
        } catch (IOException e) {
            System.out.println("Error saving students to file: " + e.getMessage());
        }
    }

    // Load student records from a text file
    private void loadStudentsFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return; // If file does not exist, just start with an empty list
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                if (data.length == 3) {
                    String name = data[0];
                    String rollNumber = data[1];
                    double marks = Double.parseDouble(data[2]);
                    students.add(new Student(name, rollNumber, marks));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error reading marks from file. File might be corrupted.");
        }
    }
}
