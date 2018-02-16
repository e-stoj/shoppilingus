import types.ProductTypes;

public class Product {
    private static int nextId = 0;

    private int id;
    private String name;
    private double price;
    private ProductTypes type;
    private double tax;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ProductTypes getType() {
        return type;
    }

    public double getTax() {
        return tax;
    }

    public Product(String name, double price, ProductTypes type, double tax) {
        this.id = nextId++;
        this.name = name;
        this.price = price;
        this.type = type;
        this.tax = tax;
    }

    public Product(String name, double price, ProductTypes type) {
        this(name, price, type, 0);
    }

    public Product(String name, double price){
        this(name, price, null, 0);
    }

    public double getPriceForCompany() {
        return price;
    }

    public double getPriceForConsumer() {
        double bruttoPrice = price + price * tax;
        return bruttoPrice;
    }

    public String getFullName() {
        return name;
    }

    public void print() {
        System.out.println(getFullName());
    }
}
