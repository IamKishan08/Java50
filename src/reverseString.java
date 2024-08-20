public class reverseString {
    public static void main(String[] args) {
        String s = "Hello";

        StringBuilder rev = new StringBuilder();

        char[] c = s.toCharArray();

        for(int i = c.length-1 ; i>=0 ; i--){
            rev.append(c[i]);
        }

        System.out.println(rev) ;

    }

}
