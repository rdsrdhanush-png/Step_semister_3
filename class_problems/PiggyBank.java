class PiggyBank {

    // Private savings - cannot be changed directly
    private double savings;

    // Final ID - cannot be changed after creation
    private final String id;

    // Constructor
    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            savings = savings + amount;
            System.out.println("Deposited: Rs " + amount);
        } else {
            System.out.println("Invalid deposit");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > savings) {
            System.out.println("Withdrawal rejected");
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal");
        } else {
            savings = savings - amount;
            System.out.println("Withdrawn: Rs " + amount);
        }
    }

    // Check savings
    public double getSavings() {
        return savings;
    }

    // Check ID
    public String getId() {
        return id;
    }
}

public class Main {
    public static void main(String[] args) {

        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        System.out.println("Savings: Rs " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("Savings: Rs " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("Savings: Rs " + pb.getSavings());
    }
}
