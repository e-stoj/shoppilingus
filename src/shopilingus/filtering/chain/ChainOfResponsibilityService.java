package shopilingus.filtering.chain;

import shopilingus.Shop;
import shopilingus.ShoppingCenter;
import shopilingus.filtering.FilteringParams;
import shopilingus.filtering.FilteringService;
import java.util.Arrays;
import java.util.List;

public class ChainOfResponsibilityService  implements FilteringService{

    private static List<ShopFilter> getChainOfFilters(){
        return Arrays.asList(
            new FilterByNamePhrase(),
            new FilterByFloor()
        );
    }

    @Override
    public List<Shop> filterShops(ShoppingCenter shoppingCenter, FilteringParams params) {
        List<Shop> shops = shoppingCenter.getShops();
        for(ShopFilter filter : getChainOfFilters()){
            shops = filter.filter(shops, params);
        }
        return shops;
    }
}
