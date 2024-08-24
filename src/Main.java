import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Java 50 Interview Question");

        long startTime = System.currentTimeMillis();

        int [] nums = {-1,0,1,2,-1,-4};
//
//        Solution s = new Solution();
//        System.out.println(s.brute(prices1));

        List<List<Integer>> arr = twoSums.threeSum(nums);
        System.out.println(arr);


        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        if (duration < 1000) {
            System.out.println("Time taken: " + duration + "ms");
        } else {
            System.out.println("Time taken: " + (duration / 1000.0) + " seconds");
        }

    }
}