package model;

public class Cart extends Product {
    private int quantity;

    public Cart(int product_id, String product_name, int unit_price) {
        super(product_id, product_name, unit_price);
        this.quantity = 1; // Assuming the initial quantity is 1
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}