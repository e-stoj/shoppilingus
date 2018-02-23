public class ProductDetails {
    private Product product;
    private double quantity;

    ProductDetails(Product product, double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
