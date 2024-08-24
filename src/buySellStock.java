import java.util.ArrayList;
import java.util.List;

public class buySellStock {
    public static void main(String[] args) {
          int[] prices = {7,1,5,3,6,4};
          int [] prices1 = {7,6,4,3,1,5};
          Solution s = new Solution();

        System.out.println(s.maxProfit(prices1));
    }
}

class Solution {
    public int maxProfit(int[] prices) {

        int profit = 0;

       int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min,prices[i]);
            profit = Math.max(profit,prices[i] - min);

        }


        return profit;
    }
    public int brute(int[] prices) {
        int len = prices.length;

        List<Integer> list = new ArrayList<>();

        int profit = 0;
        for (int i = 0; i < len -1 ; i++) {    // arr 0 , 1 , 2, 3, 4,5
            for (int j = i+1; j < len ; j++) { //
                if(prices[i]<prices[j]){
                    int dif = prices[j] - prices[i];
                    if(profit < dif){
                        profit = dif;

                    }
                }
            }
        }

        return profit;
    }
    }
