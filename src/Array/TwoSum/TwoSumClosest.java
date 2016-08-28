package Array.TwoSum;

import java.util.Arrays;

/**
 * Created by Frank on 16/8/16.
 */
public class TwoSumClosest {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumCloset(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int best = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        while(i < j){
            if(nums[i] + nums[j] == target){
                return 0;
            }
            if(nums[i] + nums[j] < target){
                diff = Math.abs(nums[i] + nums[j] - target);
                i++;
            } else {
                diff = Math.abs(nums[i] + nums[j] - target);
                j--;
            }
            best = Math.min(best, diff);
        }
        return best;
    }
}
