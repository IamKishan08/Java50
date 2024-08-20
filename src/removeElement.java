public class removeElement {
    public static void main(String[] args) {
        int[] arr = {3,2,2,3};
        int val = 3;
        int s = removeElement(arr, val);
        System.out.println("Number of elements: " + s);

        for (int i = 0; i < s; i++) {
            System.out.print(arr[i] + " ");
        }

    }
    private static int removeElement(int[] nums, int val) {
        int k =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
