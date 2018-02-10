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
            if (currentShop.id == shopId) {
                return currentShop;
            }
        }
        return null;
    }

    public void updateShop(int shopId, Shop modifiedShop) {
        deleteShop(shopId);
        modifiedShop.id = shopId;
        addShop(modifiedShop);
    }

    public void deleteShop(int shopId) {
        for (int i = 0; i < shops.size(); i++) {
            Shop currentShop = shops.get(i);
            if (currentShop.id == shopId) {
                shops.remove(currentShop);
                break;
            }
        }
    }

    public List<Shop> findShopsByName(String name) {
        return shops.stream()
                .filter(shop -> shop.name.equals(name))
                .collect(Collectors.toList());
    }

    public Shop findShopById(int shopId) {
        return shops.stream()
                .filter(shop -> shop.id == shopId)
                .findFirst()
                .orElse(null);
    }

    public List<Product> getAllProducts(){
        LinkedList<Product> allProducts = new LinkedList();
        for(Shop shop : shops){
            for(ProductDetails productDetail : shop.products){
                allProducts.add(productDetail.product);
            }
        }
        return allProducts;
    }

    public List<Service> getAllServices(){
        LinkedList<Service> allServices = new LinkedList();
        for(Shop shop : shops){
                allServices.addAll(shop.services);
        }
        return allServices;
    }

    public Set<String> getAllShopTypes(){
        Set<String> allShopTypes = new HashSet<>();
        for(Shop shop : shops){
            allShopTypes.addAll(shop.type);
        }
        return allShopTypes;
    }

    public Set<String> getAllProductTypes(){
        return getAllProducts().stream()
                .map(product -> product.type)
                .collect(Collectors.toSet());
    }
}