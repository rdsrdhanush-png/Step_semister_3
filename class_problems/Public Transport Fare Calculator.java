import java.util.Scanner;

abstract class Transport {
    double dist;

    Transport(double dist) {
        this.dist = dist;
    }

    abstract double calc();
}

class Bus extends Transport {
    Bus(double dist) {
        super(dist);
    }

    double calc() {
        return Math.min(10, 2 + dist * 0.10);
    }
}

class Train extends Transport {
    Train(double dist) {
        super(dist);
    }

    double calc() {
        return 3 + dist * 0.15;
    }
}

class Metro extends Transport {
    double factor;

    Metro(double dist, double factor) {
        super(dist);
        this.factor = factor;
    }

    double calc() {
        return (1.50 + dist * 0.20) * factor;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double dist = sc.nextDouble();

            Transport t;

            if (type.equals("BUS")) {
                t = new Bus(dist);
            } else if (type.equals("TRAIN")) {
                t = new Train(dist);
            } else {
                double factor = sc.nextDouble();
                t = new Metro(dist, factor);
            }

            double ans = t.calc();

            System.out.printf("%s: %.2f%n", type, ans);
            total += ans;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
