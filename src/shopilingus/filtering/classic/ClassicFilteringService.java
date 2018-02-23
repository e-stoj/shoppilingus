package shopilingus.filtering.classic;

import shopilingus.Shop;
import shopilingus.ShoppingCenter;
import shopilingus.filtering.FilteringParams;
import shopilingus.filtering.FilteringService;

import java.util.ArrayList;
import java.util.List;

public class ClassicFilteringService implements FilteringService {

    private List<Shop> filterByName(List<Shop> shops, FilteringParams params) {
        List<Shop> newList = new ArrayList<>();
        for (Shop shop : shops) {
            if (shop.getName().contains(params.getName())) {
                newList.add(shop);
            }
        }
        return newList;
    }

    private List<Shop> filterByFloor(List<Shop> shops, FilteringParams params) {
        List<Shop> newList = new ArrayList<>();
        for (Shop shop : shops) {
            if (shop.getLocation().getFloor() == params.getFloor()) {
                newList.add(shop);
            }
        }
        return newList;
    }

    @Override
    public List<Shop> filterShops(ShoppingCenter shoppingCenter, FilteringParams params) {
        List<Shop> result = new ArrayList<>();
        result = filterByName(shoppingCenter.getShops(), params);
        result = filterByFloor(result, params);

        return result;
    }
}
