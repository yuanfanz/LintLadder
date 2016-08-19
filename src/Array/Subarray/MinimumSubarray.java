package Array.Subarray;

import java.util.ArrayList;

/**
 * Created by Frank on 16/8/15.
 */
public class MinimumSubarray {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.isEmpty()){
            return 0;
        }
        int maxSum = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.size(); ++i){
            sum += nums.get(i);
            min = Math.min(min, sum - maxSum);
            maxSum = Math.max(maxSum, sum);
        }
        return min;
    }
}
