package DynamicProgramming.Coordinate;

/**
 * Created by yuanf on 2016/7/16.
 */
public class LIS {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] sum = new int[n];
        int max = 0;
        for(int i = 0; i < n; ++i){
            sum[i] = 1;
            for(int j = 0; j < i; ++j){
                if(nums[j] <= nums[i]){
                    sum[i] = sum[i] >= sum[j] + 1 ? sum[i] : sum[j] + 1;
                }
            }
            if(sum[i] > max){
                max = sum[i];
            }
        }
        return max;
    }
}
