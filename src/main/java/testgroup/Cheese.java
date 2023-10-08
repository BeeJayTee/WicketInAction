package testgroup;

public class Cheese implements java.io.Serializable {
    public String name;
    public String description;
    public double price;
    public Cheese (String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() { return this.description; }
}
