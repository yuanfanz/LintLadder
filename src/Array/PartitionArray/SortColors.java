package Array.PartitionArray;

/**
 * Created by Frank on 16/8/17.
 */
public class SortColors {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return;
        }
        int left = 0, right = nums.length - 1;
        int i = 0;
        while(i <= right){
            if(nums[i] > 1){
                int tmp = nums[i];
                nums[i] = nums[right];
                nums[right] = tmp;
                right--;
            } else if (nums[i] < 1){
                int tmp = nums[i];
                nums[i] = nums[left];
                nums[left] = tmp;
                i++;
                left++;
            } else {
                i++;
            }
        }
    }
}
