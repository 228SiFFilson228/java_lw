import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class App {
    public static void main(String[] args) throws Exception {
        String test = "abcdefgh";
        String coded = EncodeString(test);
        String decoded = EncodeString(coded);
        System.out.println(coded);
        System.out.println(decoded);

        String poem = "Я достаю из широких штанин паспорт";
        SortWords(poem);
    }


    public static String EncodeString(String input) {
        int len = input.length();
        String result = "";

        int offset = 0;
        while (result.length() < len) {
            int index = 0 + offset;

            while (index < input.length()) {
                result += input.charAt(index);
                index += 3;
            }

            offset++;
        }

        return result;
    }

    public static void SortWords(String input) {
        ArrayList<String> allMatches = new ArrayList<String>();

        Matcher m = Pattern.compile("\\b[А-Яа-яЁё]+\\b").matcher(input);

        while (m.find()) {
            allMatches.add(m.group());
        }

        TreeMap<Character, ArrayList<String>> words = new TreeMap<>();

        for (String w:allMatches) {
            ArrayList<String> s = words.get(Character.toLowerCase(w.charAt(0)));
            if (s == null) {
                words.put(Character.toLowerCase(w.charAt(0)), new ArrayList<>());
                words.get(Character.toLowerCase(w.charAt(0))).add(w.toLowerCase());
            } else {
                s.add(w.toLowerCase());
            }
        }

        for (ArrayList<String> ar : words.values()) {
            System.out.println("  " + String.join(", ", ar));
        }

    }
}
