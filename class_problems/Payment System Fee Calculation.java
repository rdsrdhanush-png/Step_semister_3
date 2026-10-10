import java.util.Scanner;

abstract class Payment {
    double amt;

    Payment(double amt) {
        this.amt = amt;
    }

    abstract double calc();
}

class Card extends Payment {
    Card(double amt) {
        super(amt);
    }

    double calc() {
        return amt * 1.02;
    }
}

class Wallet extends Payment {
    Wallet(double amt) {
        super(amt);
    }

    double calc() {
        return amt * 1.01;
    }
}

class BankTransfer extends Payment {
    BankTransfer(double amt) {
        super(amt);
    }

    double calc() {
        return amt;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amt = sc.nextDouble();

            Payment p;

            if (type.equals("CARD")) {
                p = new Card(amt);
            } else if (type.equals("WALLET")) {
                p = new Wallet(amt);
            } else {
                p = new BankTransfer(amt);
            }

            double ans = p.calc();

            System.out.printf("%s: %.2f%n", type, ans);
            total += ans;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
