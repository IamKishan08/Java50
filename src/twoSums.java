
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class twoSums {
    public static void main(String[] args) {
        int[] nums = {1,-1,-1,0 };
        //int target = 0;The value changed at 'right--' is never used

        List<List<Integer>> arr = threeSum(nums);
        System.out.println(arr);

//        HashMap<Integer,Integer> map = new HashMap<>();
//
//        for(int i = 0; i < nums.length; i++) {
//            int val = target-nums[i];
//           if (map.containsKey(val)){
//               System.out.println(map.get(val)+","+i);
//           }
//           else {
//               map.put(nums[i],i);
//           }
//        }
    }

    private static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> answer  = new ArrayList<>();



        for (int i = 0; i < nums.length-2 && nums[i] <= 0; ++i) {

            if(i>0 && nums[i] == nums[i-1]) continue;
            int left = i +1;
            int right = nums.length -1;

            while (left < right) {
                int sum = nums[i] + nums [left] + nums[right] ;
                if (sum > 0) {
                    --right;
                } else if (sum < 0) {
                    ++left;
                } else {
                    answer.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }
            }
        }
        return answer;
    }
}