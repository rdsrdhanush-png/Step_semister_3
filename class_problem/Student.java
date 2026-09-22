class Student {

    // Instance fields
    String name;
    double attendance;

    // Static fields - shared by all students
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    // Constructor
    Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;

        // Increase count whenever a Student object is created
        studentCount++;
    }

    // Static method
    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class Main {
    public static void main(String[] args) {

        // Create two Student objects
        Student s1 = new Student("Ravi", 85.5);
        Student s2 = new Student("Arun", 90.0);

        System.out.println("2 Student objects created");
        System.out.println();

        // Call static method using CLASS NAME
        Student.printCollegeInfo();
    }
}
