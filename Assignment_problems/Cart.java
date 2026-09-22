class Cart {

    // Private data
    private double[] prices;
    private int itemCount;

    // Final cart ID
    private final String cartId;

    // Constructor
    Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        prices = new double[maxItems];
        itemCount = 0;
    }

    // Add an item price
    void addItem(double price) {
        if (itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        } else {
            System.out.println("Cart is full!");
        }
    }

    // Calculate total whenever called
    double getTotal() {
        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total = total + prices[i];
        }

        return total;
    }

    // Return number of items
    int getItemCount() {
        return itemCount;
    }

    // Return cart ID
    String getCartId() {
        return cartId;
    }
}

public class Main {
    public static void main(String[] args) {

        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Cart ID: " + cart.getCartId());
        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item Count: " + cart.getItemCount());
    }
}
