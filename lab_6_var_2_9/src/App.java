// Java implementation of the approach
import java.util.*;
 
class App
{
 
static int row = 6;
static int col = 8;
 
// Function to find the maximum rectangular
// area under given histogram with n bars
static int cal(int hist[], int n)
{
    // Create an empty stack. The stack holds indexes
    // of hist[] array. The bars stored in stack are
    // always in increasing order of their heights.
    Stack<Integer> s = new Stack<>();
 
    // Initialize max area
    int max_area = 0;
 
    // To store top of the stack
    int tp;
 
    // To store area with top bar
    int area_with_top;
    // as the smallest bar
 
    // Run through all bars of given histogram
    int i = 0;
    while (i < n)
    {
 
        // If this bar is higher than the bar on top
        // stack, push it to stack
        if (s.empty() || hist[s.peek()] <= hist[i])
            s.push(i++);
 
        // If this bar is lower than top of stack,
        // then calculate area of rectangle with stack
        // top as the smallest (or minimum height) bar.
        // 'i' is 'right index' for the top and element
        // before top in stack is 'left index'
        else
        {
 
            // Store the top index
            tp = s.peek();
 
            // Pop the top
            s.pop();
 
            // Calculate the area with hist[tp] stack
            // as smallest bar
            area_with_top = hist[tp] * (s.empty() ? i :
                                     i - s.peek() - 1);
 
            // Update max area, if needed
            if (max_area < area_with_top)
                max_area = area_with_top;
        }
    }
 
    // Now pop the remaining bars from stack and calculate
    // area with every popped bar as the smallest bar
    while (s.empty() == false)
    {
        tp = s.peek();
        s.pop();
        area_with_top = hist[tp] * (s.empty() ? i :
                                 i - s.peek() - 1);
 
        if (max_area < area_with_top)
            max_area = area_with_top;
    }
    return max_area;
}
 
// Function to find largest sub matrix
// with all equal elements
static int largestMatrix(int a[][])
{
    // To find largest sub matrix
    // with all elements 1
    int [][]dp = new int[row][col];
 
    // Fill dp[][] by traversing each
    // column from bottom to up
    for (int i = 0; i < col; i++)
    {
        int cnt = 0;
        for (int j = row - 1; j >= 0; j--)
        {
            dp[j][i] = 0;
            if (a[j][i] == 1)
            {
                cnt++;
                dp[j][i] = cnt;
            }
            else
            {
                cnt = 0;
            }
        }
    }
 
    int ans = -1;
 
    for (int i = 0; i < row; i++)
    {
 
        // Maintain the histogram array
        int []hist = new int[col];
        for (int j = 0; j < col; j++)
        {
            hist[j] = dp[i][j];
        }
 
        // Find maximum area rectangle in Histogram
        ans = Math.max(ans, cal(hist, col));
    }
 
    // To fill dp[][] for finding largest
    // sub matrix with all elements 0
    for (int i = 0; i < col; i++)
    {
        int cnt = 0;
        for (int j = row - 1; j >= 0; j--)
        {
            dp[j][i] = 0;
            if (a[j][i] == 0)
            {
                cnt++;
                dp[j][i] = cnt;
            }
            else
            {
                cnt = 0;
            }
        }
    }
 
    for (int i = 0; i < row; i++)
    {
 
        // Maintain the histogram array
        int []hist = new int[col];
        for (int j = 0; j < col; j++)
        {
            hist[j] = dp[i][j];
        }
 
        // Find maximum area rectangle in Histogram
        ans = Math.max(ans, cal(hist, col));
    }
    return ans;
}
 
// Driver code
public static void main(String[] args)
{
    int a[][] = {{ 1, 1, 0, 1, 0, 0, 0, 0 },
                 { 0, 1, 1, 1, 1, 0, 0, 1 },
                 { 1, 0, 0, 1, 1, 1, 0, 0 },
                 { 0, 1, 1, 0, 1, 1, 0, 0 },
                 { 1, 0, 1, 1, 1, 1, 1, 0 },
                 { 0, 0, 1, 1, 1, 1, 1, 1 }};
 
    System.out.println(largestMatrix(a));
}
}
 