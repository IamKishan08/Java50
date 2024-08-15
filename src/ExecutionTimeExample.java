import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExecutionTimeExample {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 7, 9, 11));

        // Measure time for oddNumbers method
        long startTimeOddNumbers = System.nanoTime();
        boolean resultOddNumbers = oddNumbers(list);
        long endTimeOddNumbers = System.nanoTime();
        long durationOddNumbers = (endTimeOddNumbers - startTimeOddNumbers) / 1_000_000; // Convert to milliseconds
        System.out.println("oddNumbers result: " + resultOddNumbers);
        System.out.println("Time taken by oddNumbers method: " + durationOddNumbers + " ms");

        // Measure time for onlyOddNumbers method
        long startTimeOnlyOddNumbers = System.nanoTime();
        boolean resultOnlyOddNumbers = onlyOddNumbers(list);
        long endTimeOnlyOddNumbers = System.nanoTime();
        long durationOnlyOddNumbers = (endTimeOnlyOddNumbers - startTimeOnlyOddNumbers) / 1_000_000; // Convert to milliseconds
        System.out.println("onlyOddNumbers result: " + resultOnlyOddNumbers);
        System.out.println("Time taken by onlyOddNumbers method: " + durationOnlyOddNumbers + " ms");
    }

    private static boolean oddNumbers(List<Integer> list) {
        for (int li : list) {
            if (li % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    // Another method using parallel stream
    public static boolean onlyOddNumbers(List<Integer> list) {
        return list
                .parallelStream() // parallel stream for faster processing
                .allMatch(x -> x % 2 != 0); // return as soon as any elements match the condition
    }
}
