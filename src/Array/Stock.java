package Array;

/**
 * Created by Frank on 16/8/9.
 */
public class Stock {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null || prices.length == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0; i < prices.length; ++i){
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
}