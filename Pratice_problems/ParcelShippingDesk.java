
import java.util.Locale;
import java.util.Scanner;

interface Insurable {
    double getInsurance(double declaredValue);
}

abstract class Parcel {
    double weight;
    double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double getCharge();

    double getInsurance() {
        return 0.0;
    }
}

class StandardParcel extends Parcel {
    StandardParcel(double weight, double value) {
        super(weight, value);
    }

    double getCharge() {
        return 40 + 10 * weight;
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weight, double value) {
        super(weight, value);
    }

    double getCharge() {
        return 80 + 15 * weight;
    }

    public double getInsurance(double value) {
        return value * 0.02;
    }

    double getInsurance() {
        return getInsurance(declaredValue);
    }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weight, double value) {
        super(weight, value);
    }

    double getCharge() {
        return 40 + 10 * weight + 50;
    }

    public double getInsurance(double value) {
        return value * 0.02;
    }

    double getInsurance() {
        return getInsurance(declaredValue);
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double grandTotal = 0;

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            Parcel parcel;

            switch (type) {
                case "STANDARD":
                    parcel = new StandardParcel(weight, value);
                    break;
                case "EXPRESS":
                    parcel = new ExpressParcel(weight, value);
                    break;
                case "FRAGILE":
                    parcel = new FragileParcel(weight, value);
                    break;
                default:
                    continue;
            }

            double charge = parcel.getCharge();
            double insurance = parcel.getInsurance();
            double total = charge + insurance;

            System.out.printf(Locale.US,
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total);

            grandTotal += total;
        }

        System.out.printf(Locale.US, "Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
