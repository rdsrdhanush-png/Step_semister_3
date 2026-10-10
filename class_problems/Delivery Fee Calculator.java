import java.util.Scanner;

abstract class Delivery {
    double wt, dist;

    Delivery(double wt, double dist) {
        this.wt = wt;
        this.dist = dist;
    }

    abstract double calc();
}

class Standard extends Delivery {
    Standard(double wt, double dist) {
        super(wt, dist);
    }

    double calc() {
        return 5 + wt * 0.50 + dist * 0.10;
    }
}

class Express extends Delivery {
    Express(double wt, double dist) {
        super(wt, dist);
    }

    double calc() {
        return 15 + wt + dist * 0.20;
    }
}

class International extends Delivery {
    double customs;

    International(double wt, double dist, double customs) {
        super(wt, dist);
        this.customs = customs;
    }

    double calc() {
        return 25 + wt * 2 + dist * 0.50 + customs;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double wt = sc.nextDouble();
            double dist = sc.nextDouble();

            Delivery d;

            if (type.equals("STANDARD")) {
                d = new Standard(wt, dist);
            } else if (type.equals("EXPRESS")) {
                d = new Express(wt, dist);
            } else {
                double customs = sc.nextDouble();
                d = new International(wt, dist, customs);
            }

            double ans = d.calc();

            System.out.printf("%s: %.2f%n", type, ans);
            total += ans;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
