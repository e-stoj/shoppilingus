package shopilingus.filtering.chain;

import shopilingus.Shop;
import shopilingus.filtering.FilteringParams;
import java.util.ArrayList;
import java.util.List;

public class FilterByFloor implements ShopFilter {
    @Override
    public List<Shop> filter(List<Shop> shops, FilteringParams params) {
        List<Shop> newList = new ArrayList<>();
        for (Shop shop : shops) {
            if (shop.getLocation().getFloor() == params.getFloor()) {
                newList.add(shop);
            }
        }
        return newList;
    }
}
