import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGradeTracker tracker = new StudentGradeTracker();
        boolean running = true;

        while (running) {
            System.out.println("\n===== Student Grade Tracker =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Calculate Statistics");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = -1;
            
            // Validate integer input for menu choice
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume the leftover newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.nextLine(); // clear the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    String name = "";
                    while (name.isEmpty()) {
                        System.out.print("Enter Student Name: ");
                        name = scanner.nextLine().trim();
                        if (name.isEmpty()) {
                            System.out.println("Name cannot be empty. Please try again.");
                        }
                    }

                    String rollNumber = "";
                    while (rollNumber.isEmpty()) {
                        System.out.print("Enter Roll Number: ");
                        rollNumber = scanner.nextLine().trim();
                        if (rollNumber.isEmpty()) {
                            System.out.println("Roll Number cannot be empty. Please try again.");
                        } else if (tracker.isRollNumberExists(rollNumber)) {
                            System.out.println("Student with this Roll Number already exists!");
                            rollNumber = ""; // reset to prompt again
                        }
                    }

                    double marks = -1;
                    while (marks < 0 || marks > 100) {
                        System.out.print("Enter Marks (0-100): ");
                        try {
                            marks = scanner.nextDouble();
                            scanner.nextLine(); // consume the leftover newline
                            
                            if (marks < 0 || marks > 100) {
                                System.out.println("Invalid marks. Must be between 0 and 100.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid marks. Please enter a valid numeric value.");
                            scanner.nextLine(); // clear the invalid input
                        }
                    }

                    Student newStudent = new Student(name, rollNumber, marks);
                    tracker.addStudent(newStudent);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.println("\n--- All Students ---");
                    tracker.viewAllStudents();
                    break;

                case 3:
                    System.out.print("Enter Roll Number to search: ");
                    String searchRoll = scanner.nextLine().trim();
                    tracker.searchStudent(searchRoll);
                    break;

                case 4:
                    tracker.calculateStatistics();
                    break;

                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
        
        scanner.close();
    }
}
