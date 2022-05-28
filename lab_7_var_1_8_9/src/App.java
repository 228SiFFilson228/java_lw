public class App {
    public static void main(String[] args) throws Exception {
        String line = "Helloworld11@ whi1tespa1ces$  owari";
        System.out.println(PurgeNonLetters(line));

        String line2 = "agor amet solo dev";
        System.out.println(RemoveLength(line2, "a", 4));
    }

    public static String PurgeNonLetters(String input) {
        return input.replaceAll("[^a-zA-Z ]", "");
    }

    public static String RemoveLength(String input, String c, int length) {
        String regex = "\\b" + c + "\\w{" + (length - 1) + "}\\b";
        return input.replaceAll(regex, "");
    }
}
