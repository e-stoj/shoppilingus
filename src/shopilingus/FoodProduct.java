package shopilingus;

import shopilingus.types.ProductType;

import java.util.List;

public class FoodProduct extends Product {
    private List<String> ingredients;

    FoodProduct(String name, double price, List<String> ingredients) {
        super(name, price, ProductType.FOOD, 0.07);
        this.ingredients = ingredients;
    }

    @Override
    public String getFullName() {
        String result = String.join(", ", ingredients);
        return getName() + " (ingredients: " + result + ")";
    }
}
