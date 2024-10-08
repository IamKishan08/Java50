import java.util.Arrays;

public class arrayQuickSort {

    public static void main(String[] args) {
        int[] arr = {443,23,55,1,3,943,12,2,10};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr,int left, int right) {
        if(left < right){
            int pi = partition(arr,left,right);
            quickSort(arr,left, pi-1);
            quickSort(arr,pi+1,right);
        }
    }

    private static int partition(int[] arr, int left, int right) {

        int pivot = arr[right];

        int i = (left-1);
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = temp;
        return i+1;
    }

}
