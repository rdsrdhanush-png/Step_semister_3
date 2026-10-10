
import java.util.Scanner;

interface NightService {
    double NIGHT_MULTIPLIER = 1.20;

    default double applyNightFare(double fare) {
        return fare * NIGHT_MULTIPLIER;
    }
}

abstract class Cab {
    static final double MINIMUM_FARE = 100.0;

    abstract double ratePerKm();

    double calculateFare(double km) {
        return Math.max(MINIMUM_FARE, km * ratePerKm());
    }
}

class MiniCab extends Cab {
    double ratePerKm() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightService {
    double ratePerKm() {
        return 14.0;
    }
}

class SUVCab extends Cab implements NightService {
    double ratePerKm() {
        return 18.0;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase();

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new MiniCab();
                    break;
                case "SEDAN":
                    cab = new SedanCab();
                    break;
                case "SUV":
                    cab = new SUVCab();
                    break;
                default:
                    continue;
            }

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cab.calculateFare(km);

            if (time.equals("NIGHT")) {
                fare = ((NightService) cab).applyNightFare(fare);
            }

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
