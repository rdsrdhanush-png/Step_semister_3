class Staff {

    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    Staff(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class Main {
    public static void main(String[] args) {

        Staff e1 = new Staff("Arun", 40000);
        Staff e2 = new Staff("Priya", 45000);
        Staff e3 = new Staff("Rahul", 50000);

        Staff.printCompanyInfo();
    }
}
