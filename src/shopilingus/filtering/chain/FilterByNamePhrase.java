package shopilingus.filtering.chain;

import shopilingus.Shop;
import shopilingus.filtering.FilteringParams;
import java.util.ArrayList;
import java.util.List;

public class FilterByNamePhrase implements ShopFilter {

    @Override
    public List<Shop> filter(List<Shop> shops, FilteringParams params) {
        List<Shop> newList = new ArrayList<>();
        for (Shop shop : shops) {
            if (shop.getName().contains(params.getName())) {
                newList.add(shop);
            }
        }
        return newList;
    }
}
