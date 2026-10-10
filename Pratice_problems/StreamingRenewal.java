import java.util.Scanner;
import java.time.LocalDate;

abstract class Plan {
    String name;
    LocalDate startDate;

    Plan(String name, String date) {
        this.name = name;
        this.startDate = LocalDate.parse(date);
    }

    abstract int days();

    LocalDate renewal() {
        return startDate.plusDays(days());
    }
}

class Basic extends Plan {
    Basic(String name, String date) {
        super(name, date);
    }

    int days() {
        return 30;
    }
}

class Standard extends Plan {
    Standard(String name, String date) {
        super(name, date);
    }

    int days() {
        return 90;
    }
}

class Premium extends Plan {
    Premium(String name, String date) {
        super(name, date);
    }

    int days() {
        return 365;
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String date = sc.next();
            Plan p;

            if (type.equalsIgnoreCase("BASIC")) {
                p = new Basic(name, date);
            } else if (type.equalsIgnoreCase("STANDARD")) {
                p = new Standard(name, date);
            } else {
                p = new Premium(name, date);
            }

            System.out.println(p.name + ": " + p.renewal());
        }

        sc.close();
    }
}
