import Model.Product;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Product p1 = new Product(1, "bla", "Books", 150);
        Product p2 = new Product(2, "blabla", "PC", 1500);
        Product p3 = new Product(3, "blablabla", "Books", 99);
        Product p4 = new Product(4, "abc", "Books", 110);
        Product p5 = new Product(5, "lalalala", "Tablet", 800);
        Product p6 = new Product(1, "MrRobot", "TV-Series", 20);

        List<Product> productList = List.of(p1, p2, p3, p4, p5, p6);

        System.out.println("Prodotti iniziali: " + productList);
        System.out.print("Prodotti categoria Books e prezzo > 100: ");

        System.out.println(productList.stream().filter(p -> p.getCategory().equals("Books") && p.getPrice() > 100).toList());
        System.out.println(productList.parallelStream().filter(p -> p.getCategory().equals("Books") && p.getPrice() > 100).toList());


    }

}
