package filtering;

import types.ProductType;
import types.ShopType;
import types.SizeType;

import java.util.List;

public class FilteringParams {
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
}
