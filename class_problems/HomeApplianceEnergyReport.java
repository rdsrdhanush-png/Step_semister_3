
import java.util.Scanner;

interface SaverMode {
    double SAVER_FACTOR = 0.75;

    default double applySaver(double units) {
        return units * SAVER_FACTOR;
    }
}

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double powerRating();

    double calculateUnits() {
        return powerRating() * hours / 1000.0;
    }

    double calculateCost(double units) {
        return units * 8.0;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double powerRating() {
        return 150.0;
    }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double hours) {
        super(hours);
    }

    double powerRating() {
        return 1500.0;
    }
}

class Television extends Appliance {
    Television(double hours) {
        super(hours);
    }

    double powerRating() {
        return 100.0;
    }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(double hours) {
        super(hours);
    }

    double powerRating() {
        return 500.0;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNextLine()) {
                String rest = sc.nextLine().trim();
                saver = rest.equalsIgnoreCase("SAVER");
            }

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;
                case "AC":
                    appliance = new AirConditioner(hours);
                    break;
                case "TV":
                    appliance = new Television(hours);
                    break;
                case "WASHER":
                    appliance = new WashingMachine(hours);
                    break;
                default:
                    continue;
            }

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits();

            if (saver) {
                units = ((SaverMode) appliance).applySaver(units);
            }

            double cost = appliance.calculateCost(units);

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
