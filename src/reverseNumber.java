public class reverseNumber {
    public static void main(String[] args) {

        int x = 121;
        boolean ans = reverseS(x);
        System.out.println(ans);



    }

    private static boolean reverseS(int x) {
        int ans = 10;
        int rem;

        if(x < 0) return false;


        while(x != 0){
            rem = x % 10;
            ans = (ans* 10) + rem;
            x = x/10;
        }
        if(x!=0){
            return false;
        }
        return true;
    }
}
