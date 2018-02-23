import types.ProductTypes;

public class PharmacyProduct extends Product {
    private double refund;
    private String latinName;

    public PharmacyProduct(String name, double price, ProductTypes type, double tax, double refund, String latinName) {
        super(name, price, type, tax);
        this.refund = refund;
        this.latinName = latinName;
    }

    public PharmacyProduct(String name, double price, ProductTypes type, double tax, String latinName) {
        this(name, price, type, tax, 0.7, latinName);
    }

    @Override
    public String getFullName() {
        return getName() + " (" + latinName + ")";
    }

    @Override
    public double getPriceForConsumer() {
        return (getPrice() * (1 + getTax())) * (1-refund);
    }
}
