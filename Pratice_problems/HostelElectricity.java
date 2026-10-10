import java.util.Scanner;

abstract class Room {
    int units;

    Room(int units) {
        this.units = units;
    }

    abstract double calc();
}

class Single extends Room {
    Single(int units) {
        super(units);
    }

    double calc() {
        return units * 8.0;
    }
}

class Shared extends Room {
    int occupants;

    Shared(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    double calc() {
        if (occupants <= 0) return 0;
        return units * 6.0 / occupants;
    }
}

class AC extends Room {
    AC(int units) {
        super(units);
    }

    double calc() {
        return units * 10.0 + 200;
    }
}

public class HostelElectricity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Room r;

            if (type.equalsIgnoreCase("SINGLE")) {
                r = new Single(units);
            } else if (type.equalsIgnoreCase("SHARED")) {
                int occupants = sc.nextInt();
                r = new Shared(units, occupants);
            } else {
                r = new AC(units);
            }

            double ans = r.calc();
            System.out.printf("%s: %.2f%n", type, ans);
            total += ans;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
