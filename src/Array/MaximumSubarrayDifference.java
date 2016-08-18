package Array;

/**
 * Created by Frank on 16/8/15.
 */
public class MaximumSubarrayDifference {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        int sum = 0;
        int minSum = 0;
        int maxSum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for(int i = 0; i < nums.length; ++i){
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            left[i] = max;
        }
        sum = 0;
        for(int i = nums.length - 1; i >= 0; --i){
            sum += nums[i];
            min = Math.min(min, sum - maxSum);
            maxSum = Math.max(maxSum, sum);
            right[i] = min;
        }
        int maxDiffOne = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length - 1; ++i){
            maxDiffOne = Math.max(maxDiffOne, Math.abs(left[i] - right[i + 1]));
        }
        sum = 0;
        minSum = 0;
        maxSum = 0;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        left = new int[nums.length];
        right = new int[nums.length];

        for(int i = 0; i < nums.length; ++i){
            sum += nums[i];
            min = Math.min(min, sum - maxSum);
            maxSum = Math.max(maxSum, sum);
            left[i] = min;
        }
        sum = 0;
        for(int i = nums.length - 1; i >= 0; --i){
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            right[i] = max;
        }
        int maxDiffTwo = Integer.MIN_VALUE;
        for(int i = nums.length - 1; i > 0; --i){
            maxDiffTwo = Math.max(maxDiffTwo, Math.abs(right[i] - left[i - 1]));
        }
        return Math.max(maxDiffOne, maxDiffTwo);
    }
}