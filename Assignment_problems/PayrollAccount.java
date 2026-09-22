class PayrollAccount {

    // Private variables
    private double basicSalary;
    private double bonus;

    // Constructor
    public PayrollAccount(double openingSalary) {

        if (openingSalary < 0) {
            System.out.println("Warning: Negative salary. Starting with Rs 0.");
            basicSalary = 0;
        } else {
            basicSalary = openingSalary;
        }

        bonus = 0;
    }

    // Add bonus
    public void creditBonus(double amount) {

        if (amount <= 0) {
            System.out.println("Bonus rejected: amount must be greater than 0");
        } else {
            bonus = bonus + amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    // Deduct tax
    public void deductTax(double percent) {

        if (percent < 0 || percent > 100) {
            System.out.println("Tax rejected: percent must be between 0 and 100");
        } else {

            basicSalary = basicSalary - (basicSalary * percent / 100);

            System.out.println("Tax deducted: " + percent + "%");
        }
    }

    // Return net salary
    public double getNetSalary() {
        return basicSalary + bonus;
    }
}

public class Main {

    public static void main(String[] args) {

        PayrollAccount account = new PayrollAccount(50000);

        account.creditBonus(5000);

        account.deductTax(10);

        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}
