import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> list = Arrays.asList("A", "B", "C", "D", "A", "B", "C");

        // Get list without duplicates
        List<String> distinctItems = list.stream()
                                            .distinct()
                                            .collect(Collectors.toList());

        // Let's verify distinct elements
        System.out.println(distinctItems);



        List<String> list2 = Arrays.asList("A", "B", "C", "D", "A", "B", "C");
        long count = list2.stream().filter(c -> c == "A").count();
        System.out.println(count);
    }
}
