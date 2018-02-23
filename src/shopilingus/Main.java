package shopilingus;

import shopilingus.filtering.FilteringParams;
import shopilingus.filtering.FilteringService;
import shopilingus.filtering.classic.ClassicFilteringService;
import shopilingus.types.ProductType;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Shop biedronka = new Shop("biedronka", 1, 15);
        Shop cropp = new Shop("cropp", 2, 13);
        Shop rossmann = new Shop("rossmann", 1,11);

        Product chleb = new Product("chleb", 2.5, ProductType.FOOD);
        Product maslo = new Product("maslo", 10, ProductType.FOOD);

        ShoppingCenter galeriaRzeszow = new ShoppingCenter("Galeria Rzeszow");

        galeriaRzeszow.addShop(biedronka);
        galeriaRzeszow.addShop(cropp);
        galeriaRzeszow.addShop(rossmann);

        biedronka.addProduct(chleb, 5);
        biedronka.addProduct(chleb, 10);
        biedronka.addProduct(maslo, 8);
        biedronka.deleteProduct(0);
        System.out.println(biedronka);

        PharmacyProduct lek = new PharmacyProduct("xxx", 23,"yyy", "xxxxx");
        LinkedList<String> skladniki = new LinkedList<>();
        skladniki.add("chleb");
        skladniki.add("maslo");
        FoodProduct kanapka = new FoodProduct("kanapka", 2.50, skladniki);
        kanapka.print();
        lek.print();

        FilteringParams filteringParams = new FilteringParams();
        filteringParams.setName("ro");
        filteringParams.setFloor(1);

        FilteringService filteringService = new ClassicFilteringService();
        List<Shop> result = filteringService.filterShops(galeriaRzeszow, filteringParams);
        System.out.println(result);
    }
}
