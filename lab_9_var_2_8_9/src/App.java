import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 7, 14);

        Integer sum = integers.stream()
        .filter(c -> c % 7 == 0)
        .reduce(0, Integer::sum);

        System.out.println(sum);

        Integer min = integers.stream().reduce(Math::min).orElse(0);
        Integer max = integers.stream().reduce(Math::max).orElse(0);

        System.out.println(min);
        System.out.println(max); 
    }
}
