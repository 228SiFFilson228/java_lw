import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) throws Exception {
        String telegram = "Ichi ni    san yon  go roku   shichi";
        System.out.println(CalculateCost(telegram, 10));

        String poem = """
        children sleep,
        exchanging dreams her
        seraphim
        """;

        System.out.println(Arrays.toString(FindSameWords(poem).toArray()));
    }


    public static int CalculateCost(String input, int price) {
        int cost = 0;

        String[] str = input.split(" +");
        cost = str.length * price;

        return cost;
    }

    public static HashSet<Character> FindSameWords(String input) {
        ArrayList<String> allMatches = new ArrayList<String>();

        Matcher m = Pattern.compile("\\b\\w+\\b")
        .matcher(input);

        while (m.find()) {
            allMatches.add(m.group());
        }

        ArrayList<HashSet<Character>> wordletters = new ArrayList<HashSet<Character>>();

        for (String w : allMatches) {
            HashSet<Character> charset = new HashSet<>();

            for(char c : w.toCharArray()) {
                charset.add(c);
            }

            wordletters.add(charset);
            System.out.println(Arrays.toString(charset.toArray()));
        }        

        HashSet<Character> cache = new HashSet<>();
        for (int i = 0; i < wordletters.size(); i++) {
            if (i == 0) 
                cache = wordletters.get(i);
            else
                cache.retainAll(wordletters.get(i));
        }

        return cache;
    }

}
