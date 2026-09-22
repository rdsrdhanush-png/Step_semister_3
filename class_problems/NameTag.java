class NameTag {

    // Final fields - cannot be changed after creation
    private final String firstName;
    private final String lastName;

    // Constructor
    public NameTag(String fullName) {

        // Split the full name
        String[] parts = fullName.split(" ");

        firstName = parts[0];
        lastName = parts[1];
    }

    // Return nickname
    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }
}

public class Main {
    public static void main(String[] args) {

        NameTag tag = new NameTag("Maria Gomez");

        System.out.println(tag.getNickname());
    }
}
