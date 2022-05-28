import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        String input = "lorem ipsum dolor sit amet consectetur adipiscing elit Praesent blandit concoction amet";
        String[] str = input.split(" +");


        String word = "amet";
        int count = 0;
        for (String w : str) {
            if (w.toLowerCase().equals(word.toLowerCase())) count++;
        }
        System.out.println(count);

        ArrayList<String> nwords = new ArrayList<>();

        for (String w : str) {
            String regex = Character.toString(Character.toLowerCase(w.charAt(0)));
            String[] parts = w.split(regex, 2);
            if (parts.length < 2) continue;
            w = parts[0] + regex + parts[1].replaceAll(regex, "");
            nwords.add(w);
        }

        System.out.println(Arrays.toString(nwords.toArray()));

    }
}
