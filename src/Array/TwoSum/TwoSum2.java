package Array.TwoSum;

import java.util.Arrays;

/**
 * Created by Frank on 16/8/16.
 */
public class TwoSum2 {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        int i = 0, j = nums.length - 1;
        while(i < j){
            if(nums[i] + nums[j] > target){
                count += j - i;
                j--;
            } else {
                i++;
            }
        }
        return count;
    }
}