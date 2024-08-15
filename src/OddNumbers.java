import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OddNumbers {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(5, 7, 9, 11));
        boolean output = onlyOddNumbers(list);
        System.out.println(output);
    }

    private static boolean oddNumbers(List<Integer> list) {

        for (int li : list){
            if ( li % 2 == 0){
                return false;
            }
        }
            return true;
    }

    // another method using parallel stream
    public static boolean onlyOddNumbers(List<Integer> list) {
        return list
                .parallelStream() // parallel stream for faster processing
                .anyMatch(x -> x % 2 != 0); // return as soon as any elements match the condition
    }
}
