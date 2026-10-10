import java.util.Scanner;

abstract class Customer {
    double amt;

    Customer(double amt) {
        this.amt = amt;
    }

    abstract double calc();
}

class Student extends Customer {
    Student(double amt) {
        super(amt);
    }

    double calc() {
        return amt * 0.90;
    }
}

class Staff extends Customer {
    Staff(double amt) {
        super(amt);
    }

    double calc() {
        return amt * 0.95;
    }
}

class Guest extends Customer {
    Guest(double amt) {
        super(amt);
    }

    double calc() {
        return amt + 10;
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amt = sc.nextDouble();
            Customer c;

            if (type.equalsIgnoreCase("STUDENT")) {
                c = new Student(amt);
            } else if (type.equalsIgnoreCase("STAFF")) {
                c = new Staff(amt);
            } else {
                c = new Guest(amt);
            }

            double ans = c.calc();
            System.out.printf("%s: %.2f%n", type, ans);
            total += ans;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
