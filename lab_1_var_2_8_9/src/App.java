import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // 2 -- 8_9

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter N number: ");

        // This method reads the number provided using keyboard
        int n = scan.nextInt();

        Integer[] numbers = new Integer[n];

        for (int i = 0; i < n; i++) {
            int input = scan.nextInt();
            numbers[i] = input;
        }

        scan.close();

        Arrays.sort(numbers, Collections.reverseOrder());

        System.out.printf("Sorted reverse arr[] : %s \n",
                           Arrays.toString(numbers));

        Arrays.sort(numbers);

        System.out.printf("Sorted arr[] : %s \n",
                           Arrays.toString(numbers));

        System.out.print("Prime numbers:\n");
        for (Integer num : numbers) {
            if (checkPrime(num)) {
                System.out.println(num);
            }
        }
    }


    static boolean checkPrime(int n){  
        int i,m=0,flag=0;      
        m=n/2;      
        if(n==0||n==1){  
            return false;      
        } else {  
            for(i=2; i<=m; i++) {      
                if(n%i==0){      
                    return false;
                }      
            }      
            if(flag==0)  { return true; }  
        }//end of else  

        return false;
    } 
}
