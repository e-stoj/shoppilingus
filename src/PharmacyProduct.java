public class PharmacyProduct extends Product {
    private String newType;
    private double refund;
    private String latinName;

    public PharmacyProduct(String name, double price, String newType, double refund, String latinName) {
        super(name, price);
        this.newType = newType;
        this.refund = 0.70;
        this.latinName = latinName;
    }

    public PharmacyProduct(String name, double price, String newType, String latinName) {
        this(name, price, newType, 0, latinName);
    }

    @Override
    public String getFullName() {
        return getName() + " (" + latinName + ")";
    }

    @Override
    public double getPriceForConsumer() {
        double resultPrice = (getPrice() * (1 + getTax())) * (1-refund);
        return resultPrice;
    }
}
