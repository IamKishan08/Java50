public class primeNumber {

    public static void main(String[] args) {

        int n = 13;

        if(isPrime(n)){
            System.out.println("prime");
        }
        else {
            System.out.println("not prime");
        }

    }

    private static boolean isPrime(int n ){
        if(n<=1){
            return false;
        }
          // use sqrt method for best time complexity
        for (int i = 2; i < Math.sqrt(n); i++) {
               if(n % i == 0){
                   return false;
               }
        }



        return true;
    }

}
