import types.ProductTypes;
import types.SizeTypes;

public class ClothingProduct extends Product {
    SizeTypes size;

    ClothingProduct(String name, double price, SizeTypes size) {
        super(name, price, ProductTypes.CLOTHES, 0.23);
        this.size = size;
    }

    @Override
    public String getFullName() {
        return getName() + " (" + size + ")";
    }
}
