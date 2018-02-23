package shopilingus;

import shopilingus.types.ProductType;
import shopilingus.types.SizeType;

public class ClothingProduct extends Product {
    SizeType size;

    ClothingProduct(String name, double price, SizeType size) {
        super(name, price, ProductType.CLOTHES, 0.23);
        this.size = size;
    }

    @Override
    public String getFullName() {
        return getName() + " (" + size + ")";
    }
}
