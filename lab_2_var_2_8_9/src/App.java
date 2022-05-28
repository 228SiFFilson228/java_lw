import java.util.Scanner;
import java.util.Arrays;

// Лабораторная №2
// Вариант 2, задачи 8 и 9

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Введите n:");

        Scanner console = new Scanner(System.in);
        int n = console.nextInt();

        int[][] matrix = new int[n][n];

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++) {
                matrix[i][j] = (int) ((Math.random() * ((n) - (-n))) + (-n));
            }
        }

        console.close();

        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        System.out.println("Определитель матрицы : "
                         + determ(matrix, n));


        System.out.println("Среднее построчно:");
        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
            }

            
            float mean = sum / n;
            System.out.println(mean);
            
            for (int j = 0; j < n; j++) {
                matrix[i][j] -= (int) mean;
            }
        }

        System.out.println("Усредненная матрица:");
        printMatrix(matrix);
    }


    private static void printMatrix(int[][] matrix) {
        for (int i=0; i<matrix.length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }


    static void cofac(int mat[][], int temp[][],
                            int p, int q, int n)
    {
        int i = 0, j = 0;
 
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                if (row != p && col != q) {
                    temp[i][j++] = mat[row][col];
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    static int determ(int mat[][], int n)
    {
        int D = 0;
 
        if (n == 1)
            return mat[0][0];
 
        int temp[][] = new int[n][n];
 
        int sign = 1;
 
        for (int f = 0; f < n; f++) {
            cofac(mat, temp, 0, f, n);
            D += sign * mat[0][f]
                 * determ(temp, n - 1);

            sign = -sign;
        }
 
        return D;
    }
 
    static void display(int mat[][], int row, int col)
    {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                System.out.print(mat[i][j]);
 
            System.out.print("\n");
        }
    }
}
