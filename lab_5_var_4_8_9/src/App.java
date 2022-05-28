import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        try {
            
            // Получаем путь файла
            Path inputPath = Paths.get("data\\Hello.java");
            
            // Читаем все строки файла с кодом программы
            byte[] content = Files.readAllBytes(inputPath);
            String program = new String(content);

            // Обрабатываем строки - удаляем комментарии
            String out = program.trim()
                .replaceAll("/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/", "") // Многострочные
                .replaceAll("\\/\\/(.*)]*", ""); // Однострочные

            // Создаем новую директорию, если не существует
            Files.createDirectories(Paths.get("output"));

            // Задаем путь для нового файла для вывода
            Path outPath = Paths.get("output\\Hello_linted.java"); 

            // Записываем в новый файл получившийся код
            Files.write(outPath, out.getBytes());

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Произошла ошибка I/O");
            e.printStackTrace();
        }

        try {
            
            // Получаем путь файла
            System.out.println("Отрабатываем слова");

            File poem = new File("data\\strings.txt");

            Scanner reader = new Scanner(poem, "UTF-8");

            ArrayList<String> rows = new ArrayList<>();

            while (reader.hasNextLine()) {
                System.out.print(".");
                rows.add(reader.nextLine());
            }

            // Создаем новую директорию, если не существует
            Files.createDirectories(Paths.get("output"));

            // Задаем путь для нового файла для вывода
            FileWriter writer = new FileWriter("output\\strings_ch.txt", StandardCharsets.UTF_8);

            for (String r:rows) {
                String[] splitted = r.split(" ");
                String first = splitted[0];
                splitted[0] = splitted[splitted.length - 1];
                splitted[splitted.length - 1] = first;
                for (String s:splitted) {
                    writer.write(s + " ");
                }
                writer.write("\n");
            }

            writer.close();




        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Произошла ошибка I/O");
            e.printStackTrace();
        }
        
    }
}
