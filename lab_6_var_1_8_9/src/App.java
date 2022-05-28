import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        String exp = "[()]{}{[()()]()}";

        String exp_nb = "[{}";
        
        // Function call
        if (areBracketsBalanced(exp))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");        

        if (areBracketsBalanced(exp_nb))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");   



        System.out.println("Отрабатываем английский файл");

        File poem = new File("data\\text.txt");

        Scanner reader = new Scanner(poem, "UTF-8");

        HashSet<String> words = new HashSet<>();

        ArrayList<String> rows = new ArrayList<>();

        while (reader.hasNextLine()) {
            System.out.print(".");
            rows.add(reader.nextLine());
        }
        System.out.println("\n");

        for (String r:rows) {
            String[] splitted = r.split(" ");
            for (String s:splitted) {
                words.add(s.toLowerCase());
            }
        }

        for (String w:words) {
            System.out.println(w);
        }

    }

    static boolean areBracketsBalanced(String expr)
    {
        Stack<Character> stack
            = new Stack<Character>();
 
        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++)
        {
            char x = expr.charAt(i);
 
            if (x == '(' || x == '[' || x == '{')
            {
                // Push the element in the stack
                stack.push(x);
                continue;
            }
 
            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
 
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
 
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
 
        // Check Empty Stack
        return (stack.isEmpty());
    }
}
