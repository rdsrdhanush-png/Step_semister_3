class Locker {

    // Private code - cannot be read directly from outside
    private String combinationCode;

    // Final locker number
    private final int lockerNumber;

    // Constructor
    public Locker(int lockerNumber, String combinationCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = combinationCode;
    }

    // Change the code
    public void changeCode(String currentCode, String newCode) {

        // Check old code first
        if (combinationCode.equals(currentCode)) {
            combinationCode = newCode;
            System.out.println("Code changed successfully");
        } else {
            System.out.println("Code change rejected");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Locker l = new Locker(101, "1234");

        // Correct current code
        l.changeCode("1234", "5678");

        // Wrong current code
        l.changeCode("0000", "9999");
    }
}
