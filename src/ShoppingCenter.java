import types.ProductTypes;
import types.ShopTypes;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ShoppingCenter {
    private int id;
    private String name;
    private String address;
    private List<Shop> shops;

    public void addShop(Shop shop) {
        shops.add(shop);
    }

    public Shop getShop(int shopId) {
        for (Shop currentShop : shops) {
            if (currentShop.getId() == shopId) {
                return currentShop;
            }
        }
        return null;
    }

    public void updateShop(int shopId, Shop modifiedShop) {
        deleteShop(shopId);
        modifiedShop.setId(shopId);
        addShop(modifiedShop);
    }

    public void deleteShop(int shopId) {
        for (int i = 0; i < shops.size(); i++) {
            Shop currentShop = shops.get(i);
            if (currentShop.getId() == shopId) {
                shops.remove(currentShop);
                break;
            }
        }
    }

    public List<Shop> findShopsByName(String name) {
        return shops.stream()
                .filter(shop -> shop.getName().equals(name))
                .collect(Collectors.toList());
    }

    public Shop findShopById(int shopId) {
        return shops.stream()
                .filter(shop -> shop.getId() == shopId)
                .findFirst()
                .orElse(null);
    }

    public List<Product> getAllProducts() {
        LinkedList<Product> allProducts = new LinkedList();
        for (Shop shop : shops) {
            for (ProductDetails productDetail : shop.getProducts()) {
                allProducts.add(productDetail.getProduct());
            }
        }
        return allProducts;
    }

    public List<Service> getAllServices() {
        LinkedList<Service> allServices = new LinkedList();
        for (Shop shop : shops) {
            allServices.addAll(shop.getServices());
        }
        return allServices;
    }

    public Set<ShopTypes> getAllShopTypes() {
        Set<ShopTypes> allShopTypes = new HashSet<>();
        for (Shop shop : shops) {
            allShopTypes.addAll(shop.getType());
        }
        return allShopTypes;
    }

    public Set<ProductTypes> getAllProductTypes() {
        return getAllProducts().stream()
                .map(product -> product.getType())
                .collect(Collectors.toSet());
    }
}