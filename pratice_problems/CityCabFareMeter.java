
import java.util.Scanner;

interface NightService {
    double NIGHT_MULTIPLIER = 1.20;

    default double applyNightFare(double fare) {
        return fare * NIGHT_MULTIPLIER;
    }
}

abstract class Cab {
    protected double km;
    private static final double MINIMUM_FARE = 100.0;

    Cab(double km) {
        this.km = km;
    }

    abstract double ratePerKm();

    double baseFare() {
        return Math.max(MINIMUM_FARE, km * ratePerKm());
    }

    boolean supportsNightService() {
        return this instanceof NightService;
    }

    double fare(boolean night) {
        double fare = baseFare();

        if (night) {
            if (!(this instanceof NightService)) {
                throw new IllegalStateException(
                    "Night service not available");
            }

            fare = ((NightService) this).applyNightFare(fare);
        }

        return fare;
    }
}

class MiniCab extends Cab {
    MiniCab(double km) {
        super(km);
    }

    double ratePerKm() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightService {
    SedanCab(double km) {
        super(km);
    }

    double ratePerKm() {
        return 14.0;
    }
}

class SUVCab extends Cab implements NightService {
    SUVCab(double km) {
        super(km);
    }

    double ratePerKm() {
        return 18.0;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase();
            boolean night = time.equals("NIGHT");
            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new MiniCab(km);
                    break;
                case "SEDAN":
                    cab = new SedanCab(km);
                    break;
                case "SUV":
                    cab = new SUVCab(km);
                    break;
                default:
                    throw new IllegalArgumentException(
                        "Unknown cab type: " + type);
            }

            if (night && !cab.supportsNightService()) {
                System.out.println(
                    type + ": night service not available");
            } else {
                double fare = cab.fare(night);
                System.out.printf("%s: %.2f%n", type, fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
