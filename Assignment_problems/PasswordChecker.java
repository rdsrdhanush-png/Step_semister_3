class PasswordChecker {

    // Private and final - cannot be changed after creation
    private final String password;

    // Constructor
    public PasswordChecker(String password) {
        this.password = password;
    }

    // Return only the strength
    public String getStrength() {

        int length = password.length();

        if (length < 6) {
            return "Weak";
        } 
        else if (length <= 9) {
            return "Medium";
        } 
        else {
            return "Strong";
        }
    }
}

public class Main {
    public static void main(String[] args) {

        PasswordChecker pc = new PasswordChecker("abcd");

        System.out.println("Strength: " + pc.getStrength());

        PasswordChecker pc2 = new PasswordChecker("abcdefghij");

        System.out.println("Strength: " + pc2.getStrength());
    }
}
