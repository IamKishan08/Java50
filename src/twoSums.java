import java.util.HashMap;

public class twoSums {
    public static void main(String[] args) {
        int[] nums = {11,7,11,2};
        int target = 9 ;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int val = target-nums[i];
           if (map.containsKey(val)){
               System.out.println(map.get(val)+","+i);
           }
           else {
               map.put(nums[i],i);
           }
        }
    }
}