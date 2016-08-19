package Array.Subarray;

import java.util.ArrayList;

/**
 * Created by Frank on 16/8/15.
 */
public class MaximumSubarray2 {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.isEmpty()){
            return 0;
        }
        int minSum = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int[] left = new int[nums.size()];
        int[] right = new int[nums.size()];
        for(int i = 0; i < nums.size(); ++i){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            left[i] = max;
        }
        minSum = 0;
        sum = 0;
        max = Integer.MIN_VALUE;
        for(int i = nums.size() - 1; i >= 0; --i){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            right[i] = max;
        }
        max = Integer.MIN_VALUE;
        for(int i = 0; i + 1 < nums.size(); ++i){
            max = Math.max(max, left[i] + right[i + 1]);
        }
        return max;
    }
}