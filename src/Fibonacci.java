public class Fibonacci {
    public static void main(String[] args) {
        
        int n =10;
        fibonacciSeries(n);
    }

    // Print Fibonacci Series using Recursion
    
    private static void fibonacciSeries(int n ){
        
        int a = 0;  // 1 ,1
        int b = 1; // 1 , 2
        int c = 1; // 2 , 3

        for (int i = 1; i <= n; i++) {
            System.out.print(a + " "); // 0 , 1

            a = b ;
            b = c ;
            c = a + b ;
        }
        
    }
}
