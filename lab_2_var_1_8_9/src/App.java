import java.util.Scanner;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Calendar;

// Лабораторная №2
// Вариант 1, задачи 8 и 9

public class App {
    public static void main(String[] args) throws Exception {
        Formatter f = new Formatter();
        Calendar c = Calendar.getInstance();

        System.out.println(f.format(
                "Иванюк%nВремя получения задания: 25 февраля 2022 %nВремя сдачи задания: %te %tB %tY %tl:%tM %tp",
                c, c, c, c, c, c
            )
        );

        System.out.println("Введите n:");

        Scanner console = new Scanner(System.in);
        int n = console.nextInt();

        System.out.println("Введите " + n + " строк");

        String[] arr = new String[n];

        ArrayList<String> numbers_palyndromes = new ArrayList<>();

        for (int i=0; i<n; i++){
            String line = console.next();
            arr[i] = line;

            if (line.matches("[0-9]+")) {
                if(IsPalyndrome(line)) numbers_palyndromes.add(line);
            }
        }

        console.close();

        if (!numbers_palyndromes.isEmpty()) {
            if (numbers_palyndromes.size() < 2) {
                System.out.println("Слово из цифр палиндром: " + numbers_palyndromes.get(0));
            } else {
                System.out.println("Второе слово из цифр палиндром: " + numbers_palyndromes.get(1));
            }
        }

        System.out.println("Введите k:");

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        int i = -1;

        if(k > -10000 & k <= 0) i = 0;
        if(k > 0 && k <= 5) i = 1;
        if(k > 5 && k <= 10) i = 2;
        if(k > 10 && k <= 10000) i = 3;

        switch (i) {
            case 0:
                System.out.println("(10k; 0]");
                break;
        
            case 1:
                System.out.println("(0; 5]");
                break;

            case 2:
                System.out.println("(5; 10]");
                break;

            case 3:
                System.out.println("(10; 10k]");
                break;

            default:
                System.out.println("Not valid");
                break;
        }

        sc.close();
    }


    private static boolean IsPalyndrome(String input) {
        boolean is_palyndrome = true;

        int i = 0, j = input.length() - 1;

        while (i < j) {
            if (input.charAt(i) != input.charAt(j))
                is_palyndrome = false;
            i++;
            j--;
        }

        return is_palyndrome;
    }
}
