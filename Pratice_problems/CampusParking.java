import java.util.Scanner;

abstract class Vehicle {
    int hrs;

    Vehicle(int hrs) {
        this.hrs = hrs;
    }

    abstract double calc();
}

class Bike extends Vehicle {
    Bike(int hrs) {
        super(hrs);
    }

    double calc() {
        return hrs * 10.0;
    }
}

class Car extends Vehicle {
    Car(int hrs) {
        super(hrs);
    }

    double calc() {
        if (hrs <= 0) return 0;
        return 30 + (hrs - 1) * 20.0;
    }
}

class Truck extends Vehicle {
    Truck(int hrs) {
        super(hrs);
    }

    double calc() {
        return Math.max(100, hrs * 50.0);
    }
}

public class CampusParking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hrs = sc.nextInt();
            Vehicle v;

            if (type.equalsIgnoreCase("BIKE")) {
                v = new Bike(hrs);
            } else if (type.equalsIgnoreCase("CAR")) {
                v = new Car(hrs);
            } else {
                v = new Truck(hrs);
            }

            double ans = v.calc();
            System.out.printf("%s: %.2f%n", type, ans);
            total += ans;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
