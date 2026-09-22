class Character {

    // Current health - private
    private int health;

    // Maximum health - fixed
    private final int maxHealth;

    // Constructor
    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    // Take damage
    public void takeDamage(int amount) {
        health = health - amount;

        // Health cannot go below 0
        if (health < 0) {
            health = 0;
        }
    }

    // Heal
    public void heal(int amount) {
        health = health + amount;

        // Health cannot go above maxHealth
        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    // Read-only access to health
    public int getHealth() {
        return health;
    }
}

public class Main {
    public static void main(String[] args) {

        Character c = new Character(100);

        c.takeDamage(30);
        System.out.println("Health after damage: " + c.getHealth());

        c.heal(50);
        System.out.println("Health after healing: " + c.getHealth());

        c.takeDamage(150);
        System.out.println("Health after damage: " + c.getHealth());
    }
}
