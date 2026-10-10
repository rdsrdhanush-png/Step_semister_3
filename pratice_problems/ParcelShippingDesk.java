
import java.util.Scanner;

interface Insurable {
    double insuranceAmount(double declaredValue);
}

abstract class Parcel {
    protected double weightKg;
    protected double declaredValue;

    Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    abstract double shippingCharge();

    double insurance() {
        if (this instanceof Insurable) {
            return ((Insurable) this)
                    .insuranceAmount(declaredValue);
        }
        return 0.0;
    }

    double totalCost() {
        return shippingCharge() + insurance();
    }
}

class StandardParcel extends Parcel {
    StandardParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double shippingCharge() {
        return 40.0 + 10.0 * weightKg;
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double shippingCharge() {
        return 80.0 + 15.0 * weightKg;
    }

    public double insuranceAmount(double declaredValue) {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double shippingCharge() {
        return 40.0 + 10.0 * weightKg + 50.0;
    }

    public double insuranceAmount(double declaredValue) {
        return declaredValue * 0.02;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0.0;

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
                    throw new IllegalArgumentException(
                        "Unknown parcel type: " + type);
            }

            double charge = parcel.shippingCharge();
            double insurance = parcel.insurance();
            double total = parcel.totalCost();

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
