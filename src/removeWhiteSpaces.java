public class removeWhiteSpaces {
    public static void main(String[] args) {
        String input = "He llo Wor ld";

        char[] chars = input.toCharArray();

        StringBuilder  answer = new StringBuilder();

        for (char in: chars){
            if (!Character.isWhitespace(in)){
                answer.append(in);
            }
        }

        // remove leading and trailing spaces from a string in Java
        // use trim() and strip()
        String s = "  abc  def\t";

        s = s.strip();

        System.out.println(s);

        System.out.println(answer);
    }
}
