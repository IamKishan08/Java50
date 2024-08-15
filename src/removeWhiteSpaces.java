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

        System.out.println(answer);
    }
}
