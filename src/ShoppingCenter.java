import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCenter {
    String name;
    String address;
    List<Shop> shops;

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
}