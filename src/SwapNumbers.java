public class SwapNumbers {

    // swap Two numbers without using temporary variable
    public static void main(String[] args) {
        int a = 40 ;
        int b = 20;

        a = a + b;
        b = a - b ;
        a = a - b;

        System.out.println("a:"+a);
        System.out.println("b:"+b);
    }
}
