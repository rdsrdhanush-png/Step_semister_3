class AttendanceSheet {

    // Private array - names are hidden from outside
    private String[] students;

    // Number of students currently present
    private int presentCount;

    // Constructor
    public AttendanceSheet(int maxStudents) {
        students = new String[maxStudents];
        presentCount = 0;
    }

    // Mark a student as present
    public void markPresent(String name) {

        // Check if student is already present
        if (isPresent(name)) {
            System.out.println(name + " is already marked present");
            return;
        }

        // Check if the array is full
        if (presentCount >= students.length) {
            System.out.println("Attendance sheet is full");
            return;
        }

        students[presentCount] = name;
        presentCount++;
    }

    // Return number of present students
    public int getPresentCount() {
        return presentCount;
    }

    // Check whether a student is present
    public boolean isPresent(String name) {

        for (int i = 0; i < presentCount; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {

        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount());

        System.out.println("Ben present: " + sheet.isPresent("Ben"));

        System.out.println("Chen present: " + sheet.isPresent("Chen"));
    }
}
