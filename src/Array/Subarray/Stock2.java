package Array.Subarray;

/**
 * Created by Frank on 16/8/9.
 */
public class Stock2 {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null || prices.length == 0){
            return 0;
        }
        int profit = 0;

        for(int i = 0; i + 1 < prices.length; ++i){
            int diff = prices[i + 1] - prices[i];
            if(diff > 0){
                profit += diff;
            }
        }
        return profit;
    }
}