class TrafficLight {

    // Private color - cannot be changed directly
    private String color;

    // Final ID - cannot be changed
    private final String id;

    // Constructor
    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    // Move to the next color
    public void next() {

        if (color.equals("RED")) {
            color = "GREEN";
        }
        else if (color.equals("GREEN")) {
            color = "YELLOW";
        }
        else if (color.equals("YELLOW")) {
            color = "RED";
        }
    }

    // Read-only access to color
    public String getColor() {
        return color;
    }
}

public class Main {
    public static void main(String[] args) {

        TrafficLight t = new TrafficLight("TL-9");

        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());

        t.next();
        System.out.println(t.getColor());
    }
}
