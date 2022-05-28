import java.util.ArrayList;

public class SquareEquation {
  // ax^2+bx+c=0
  int a, b, c;

  public SquareEquation() {
    a = 1;
    b = 1;
    c = 0;
  }

  public SquareEquation(int a, int b, int c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }


  public ArrayList<Double> FindRoots() {
    double d = b * b - 4.0 * a * c;

    ArrayList<Double> result = new ArrayList<>(); 

    if (d> 0.0)   
    {  
      double r1 = (-b + Math.pow(d, 0.5)) / (2.0 * a);  
      double r2 = (-b - Math.pow(d, 0.5)) / (2.0 * a);  

      result.add(r1);
      result.add(r2);

      System.out.println("The roots are " + r1 + " and " + r2);  
    }   
    else if (d == 0.0)   
    {  
      double r1 = -b / (2.0 * a);  

      result.add(r1);
      System.out.println("The root is " + r1);  
    }   
    else   
    {  
      System.out.println("Roots are not real.");  
    }  

    return result;
  }


  public void Intervals() {
    double x0 = - b / (2 * a);

    // Print the values
    if (a > 0)
    {

        // Open upward parabola function
        System.out.print("Increase = "
                + "(" + x0 + "; +Inf)\n");
        
        System.out.print("Decrease = "
                + "(-Inf; " + x0 + ")\n");
    }
    else if (a < 0)
    {

      System.out.print("Increase = "
      + "(-Inf; " + x0 + ")\n");
      // Open upward parabola function
      System.out.print("Decrease = "
              + "(" + x0 + "; +Inf)\n");
    }
    else
    {

        // If a=0 then it is not a quadratic function
        System.out.print("Not a quadratic function\n");
    }
  }

  public ArrayList<Double> Extremum() {
    double secondPart = c * 1.0 - (b * b / (4.0 * a));

    ArrayList<Double> result = new ArrayList<>();

    // Print the values
    if (a > 0)
    {

        // Open upward parabola function
        System.out.print("Maxvalue = "
                + "Infinity\n");
        result.add(Double.POSITIVE_INFINITY);
        System.out.print("Minvalue = " + secondPart);
        result.add(secondPart);
    }
    else if (a < 0)
    {

        // Open downward parabola function
        System.out.print("Maxvalue = " + secondPart + "\n");
        result.add(secondPart);
        System.out.print("Minvalue = "
                + "-Infinity");
        result.add(Double.POSITIVE_INFINITY);
    }
    else
    {

        // If a=0 then it is not a quadratic function
        System.out.print("Not a quadratic function\n");
    }

    return result;
  }
}
