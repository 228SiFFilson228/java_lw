public class App {

    // 1 -- 2_3

    public static void main(String[] args) throws Exception {
        
        // 2
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[args.length - 1 - i]);
        }

        // 3
        String[] strings = new String[] {
            "String 1", "String 2", "String 3"
        };

        for (String string : strings) {
            System.out.println(string);
        }

        for (String string : strings) {
            System.out.print(string + " ");
        }

    }
}
