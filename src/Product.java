public class Product {
    private static int nextId = 0;

    public int id;
    public String name;
    private double price;
    public String type;
    private String size;
    private double weight;
    private double tax;

    public Product(String name, double price, String type, String size, double weight, double tax) {
        this.id = nextId++;
        this.name = name;
        this.price = price;
        this.type = type;
        this.size = size;
        this.weight = weight;
        this.tax = tax;
    }

    public Product(String name, double price, String type){
        this(name, price, type, null, 0, 0);
    }

    public double getNettoPrice(Product product){
        return product.price;
    }

    public double getBruttoPrice(Product product){
        double bruttoPrice = product.price + product.price * product.tax;
        return bruttoPrice;
    }
}
