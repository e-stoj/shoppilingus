public class Main {

    public static void main(String[] args) {
        Shop biedronka = new Shop("Biedronka", 1, 15);
        Product chleb = new Product("chleb",2.5, "food");
        Product maslo = new Product("maslo", 10, "food");

        biedronka.addProduct(chleb, 5);
        biedronka.addProduct(chleb, 10);
        biedronka.addProduct(maslo, 8);
        biedronka.deleteProduct(0);
        System.out.println(biedronka);
    }
}
