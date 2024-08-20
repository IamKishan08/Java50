import java.util.HashSet;

public class removeDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        HashSet<Integer> uniqueElements = new HashSet<>();
        int k = 0; // Index for placing the next unique element

        for (int i = 0; i < nums.length; i++) {
            if (!uniqueElements.contains(nums[i])) {
                uniqueElements.add(nums[i]);
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 5, 5, 6};
        int k = removeDuplicates(nums);

        System.out.println("Number of unique elements: " + k);
        System.out.print("Array with unique elements: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }


}
