package shopilingus.filtering;

import shopilingus.Shop;
import shopilingus.ShoppingCenter;
import java.util.List;

public interface FilteringService {
    public List<Shop> filterShops(ShoppingCenter shoppingCenter, FilteringParams params);

}
