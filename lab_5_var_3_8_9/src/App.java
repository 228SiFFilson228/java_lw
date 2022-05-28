import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Работаем с Пушкиным
        try {
            System.out.println("Отрабатываем стихотворение А. Пушкина");

            File poem = new File("data\\poem_pushkin.txt");

            HashMap<String, Integer> words = new HashMap<>();
            HashMap<Character, Integer> characters = new HashMap<>();

            Scanner reader = new Scanner(poem, "UTF-8");
            
            while (reader.hasNextLine()) {
                System.out.print(".");
                String data = removeAllNonAlphaNumeric(reader.nextLine());

                String[] splitted = data.split("\\s");
                
                for (String w:splitted) {
                    if (w.equals("")) continue;

                    int count = words.containsKey(w) ? words.get(w) : 0;
                    words.put(w, count + 1);

                    for (Character c:w.toCharArray()) {
                        int c_count = characters.containsKey(c) ? characters.get(c) : 0;
                        characters.put(c, c_count + 1);
                    }
                }
            }
            System.out.print("\n");

            System.out.println("Стихотворение Пушкина успешно обработано");

            System.out.println("Подсчет слов:");
            words.entrySet().forEach(entry -> {
                System.out.println(entry.getKey() + " " + entry.getValue());
            });

            System.out.println("Подсчет символов:");
            characters.entrySet().forEach(entry -> {
                System.out.println(entry.getKey() + " " + entry.getValue());
            });
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            e.printStackTrace();
        }

        try {
            System.out.println("Отрабатываем матрицу");

            File poem = new File("data\\matrix.txt");

            Scanner reader = new Scanner(poem, "UTF-8");

            ArrayList<String> rows = new ArrayList<>();

            while (reader.hasNextLine()) {
                System.out.print(".");
                rows.add(reader.nextLine());
            }
            System.out.println("\n");

            String[] splitted = rows.get(0).split(" ");
            int n = splitted.length;

            int[][] matrix = new int[n][n];

            int i = 0;
            for (String r:rows) {
                String[] row = r.split(" ");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
                i++;
            }

            for (int k = 0; k < n; k++) {
                for (int m = 0; m < n; m++) {
                    System.out.print(matrix[k][m] + " ");
                }
                System.out.println("\n");
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            e.printStackTrace();
        } catch (Exception e) {

        }
    }

    static String removeAllNonAlphaNumeric(String s) {
        if (s == null) {
            return null;
        }
        return s.replaceAll("[^\\wА-Яа-я\\s]", "");
    }
}
