import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Product products[] = new Product[4];

        products[0] = new Product(
            1,
            "Milk",
            324678,
            "Domik v Derevne",
            100,
            14,
            5
        );

        products[1] = new Product(
            2,
            "Milk",
            324688,
            "Prostokvashino",
            120,
            7,
            15
        );

        products[2] = new Product(
            3,
            "Milk",
            324698,
            "Bryansky Molochny Kombinat",
            90,
            14,
            10
        );

        products[3] = new Product(
            4,
            "Cereal",
            122333,
            "Ovsyanka, Sir",
            150,
            90,
            10
        );

        System.out.println("По наименованию:");
        PickTitle(products, "Milk");

        System.out.println("-------------");

        System.out.println("По наименованию и не превышающие цену:");
        PickCost(products, "Milk", 110);

        System.out.println("-------------");

        System.out.println("По предельному сроку хранения:");
        PickValid(products, 14);
    }

    private static void PickTitle(Product[] products, String title) {
        Arrays.stream(products)
            .filter(c -> c.getTitle() == title)
            .forEach(c -> System.out.println(c.toString()));
    }

    private static void PickCost(Product[] products, String title, int cost) {
        Arrays.stream(products)
            .filter(c -> c.getTitle() == title)
            .filter(c -> c.getCost() < cost)
            .forEach(c -> System.out.println(c.toString()));
    }

    private static void PickValid(Product[] products, int valid) {
        Arrays.stream(products)
            .filter(c -> c.getValid_until() > valid)
            .forEach(c -> System.out.println(c.toString()));
    }
}
