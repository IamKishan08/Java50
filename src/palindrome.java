public class palindrome {

    public static void main(String[] args) {
        String s= "MALAYALAM";

        boolean result = isPalindrome(s);
        System.out.println(result);
    }

    private static boolean isPalindrome(String s) {
        int len = s.length();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(len - i -1)){
                return false;
            }
        }

        return true;
    }


}
