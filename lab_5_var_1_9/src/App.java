import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {

        try {
            SquareEquation one = new SquareEquation(1, 5, 1);
            SquareEquation two = new SquareEquation(5, 2, 3);
            SquareEquation three = new SquareEquation(6, -17, 12);

            ArrayList<Double> roots = new ArrayList<>();

            roots.addAll(one.FindRoots());
            roots.addAll(two.FindRoots());
            roots.addAll(three.FindRoots());

            System.out.println(Collections.max(roots));
            System.out.println(Collections.min(roots));

        } catch (OutOfMemoryError e) {

            System.out.println("Не хватает памяти для списка");

        } catch (ArithmeticException e) {

            System.out.println(e);

        } catch (Exception e) {

            System.out.println("Что-то пошло не так");

        }        
        

    }
}
