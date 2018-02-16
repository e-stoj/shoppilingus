import types.ProductType;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Shop biedronka = new Shop("Biedronka", 1, 15);
        Product chleb = new Product("chleb", 2.5, ProductType.FOOD);
        Product maslo = new Product("maslo", 10, ProductType.FOOD);

        biedronka.addProduct(chleb, 5);
        biedronka.addProduct(chleb, 10);
        biedronka.addProduct(maslo, 8);
        biedronka.deleteProduct(0);
        System.out.println(biedronka);

        PharmacyProduct lek = new PharmacyProduct("xxx", 23, "xxxxx");
        LinkedList<String> skladniki = new LinkedList<>();
        skladniki.add("chleb");
        skladniki.add("maslo");
        FoodProduct kanapka = new FoodProduct("kanapka", 2.50, skladniki);
        kanapka.print();
        lek.print();
    }
}
