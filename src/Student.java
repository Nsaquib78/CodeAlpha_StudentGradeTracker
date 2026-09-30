public class Student {
    private String name;
    private String rollNumber;
    private double marks;

    // Constructor to initialize a student object
    public Student(String name, String rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Getters for student fields
    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public double getMarks() {
        return marks;
    }

    // Calculate grade based on marks
    public String getGrade() {
        if (marks >= 90 && marks <= 100) return "A";
        if (marks >= 80) return "B";
        if (marks >= 70) return "C";
        if (marks >= 60) return "D";
        return "F";
    }

    // Format the student data for display
    @Override
    public String toString() {
        return "Student Name: " + name + 
               " | Roll Number: " + rollNumber + 
               " | Marks: " + marks + 
               " | Grade: " + getGrade();
    }
    
    // Format the student data for saving into a text file
    public String toFileFormat() {
        return name + "," + rollNumber + "," + marks;
    }
}
