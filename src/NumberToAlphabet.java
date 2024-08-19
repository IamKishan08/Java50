public class NumberToAlphabet {
    public static String numberToAlphabet(int number) {
        if (number < 1 || number > 26) {
            throw new IllegalArgumentException("Number must be between 1 and 26");
        }
        // Convert number to corresponding alphabet
        char alphabet = (char) ('A' + (number - 1));
        return Character.toString(alphabet);
    }

    public static void main(String[] args) {
        int number = 10;
        String result = numberToAlphabet(number);
        System.out.println("The corresponding alphabet for " + number + " is: " + result);

        number = 6;
        result = numberToAlphabet(number);
        System.out.println("The corresponding alphabet for " + number + " is: " + result);
    }
}
