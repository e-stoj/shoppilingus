package shopilingus.filtering;

import shopilingus.types.ProductType;
import shopilingus.types.ShopType;
import shopilingus.types.SizeType;

import java.util.List;

public class FilteringParams {
    private String name;
    private List<ShopType> shopTypes;
    private List<Integer> shops;
    private List<Integer> products;
    private double minPrice;
    private double maxPrice;
    private int floor;
    private boolean isOpen;
    private double minServiceDuration;
    private double quantity;
    private SizeType size;
    private double weight;
    private List<ProductType> productType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ShopType> getShopTypes() {
        return shopTypes;
    }

    public void setShopTypes(List<ShopType> shopTypes) {
        this.shopTypes = shopTypes;
    }

    public List<Integer> getShops() {
        return shops;
    }

    public void setShops(List<Integer> shops) {
        this.shops = shops;
    }

    public List<Integer> getProducts() {
        return products;
    }

    public void setProducts(List<Integer> products) {
        this.products = products;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public double getMinServiceDuration() {
        return minServiceDuration;
    }

    public void setMinServiceDuration(double minServiceDuration) {
        this.minServiceDuration = minServiceDuration;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public SizeType getSize() {
        return size;
    }

    public void setSize(SizeType size) {
        this.size = size;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public List<ProductType> getProductType() {
        return productType;
    }

    public void setProductType(List<ProductType> productType) {
        this.productType = productType;
    }
}
