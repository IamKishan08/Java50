public class factorial {
    public static void main(String[] args) {
        long n = 5;
        long result = fact(n);
        System.out.println(result);

    }
    public static long fact(long n){
        if(n==1){
            return 1;
        }
        else {
            return (n*(fact(n-1)));
        }
    }
}
