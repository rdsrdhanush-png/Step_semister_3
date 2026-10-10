
import java.util.Scanner;

interface BusUser {
    double TRANSPORT_FEE = 12000.0;

    default double transportFee() {
        return TRANSPORT_FEE;
    }
}

abstract class Student {
    protected String name;

    Student(String name) {
        this.name = name;
    }

    abstract double tuitionFee();

    double extraFee() {
        return 0.0;
    }

    double totalFee() {
        double transport = 0.0;

        if (this instanceof BusUser) {
            transport = ((BusUser) this).transportFee();
        }

        return tuitionFee() + extraFee() + transport;
    }
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double tuitionFee() {
        return 40000.0;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double tuitionFee() {
        return 40000.0;
    }

    double extraFee() {
        return 60000.0;
    }
}

class ScholarshipStudent extends Student implements BusUser {
    ScholarshipStudent(String name) {
        super(name);
    }

    double tuitionFee() {
        return 20000.0;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCollected = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new ScholarshipStudent(name);
                    break;
                default:
                    throw new IllegalArgumentException(
                        "Unknown student type: " + type);
            }

            double fee = student.totalFee();
            System.out.printf("%s: %.2f%n", name, fee);
            totalCollected += fee;
        }

        System.out.printf(
            "Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}
