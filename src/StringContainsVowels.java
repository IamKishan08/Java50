    public class StringContainsVowels {

        public static void main(String[] args) {
             String s =  "Hello";

             int count = 0;


             // check the vowels word is  present in the given String
             boolean ans = s.toLowerCase().matches(".*[aeiou].*");


            //count number of vowels in the string
            for (int i = 0; i < s.length(); i++) {
                String ch = String.valueOf(s.charAt(i)).toLowerCase();
                if(ch.matches("[aeiou]")){
                    count++;
                }
            }

            System.out.println(count);
            System.out.println(ans);
        }
    }
