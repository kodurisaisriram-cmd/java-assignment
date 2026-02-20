public class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;

    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public double getStockValue() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + quantity + "," + price;
    }

    public String display() {
        return "ID: " + id +
               " | Name: " + name +
               " | Quantity: " + quantity +
               " | Price: ₹" + price;
    }
}