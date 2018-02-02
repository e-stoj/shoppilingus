public class Product {
    public String name;
    private double price;
    private String type;
    private String size;
    private double weight;
    private double tax;

    public double getNettoPrice(Product product){
        return product.price;
    }

    public double getBruttoPrice(Product product){
        double bruttoPrice = product.price + product.price * product.tax;
        return bruttoPrice;
    }
}
