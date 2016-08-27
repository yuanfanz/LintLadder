package Array.PartitionArray;

/**
 * Created by Frank on 16/8/17.
 */
public class PartitionArrayByEvenOdd {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here;
        if(nums == null || nums.length == 0){
            return;
        }
        int i = 0, j = nums.length - 1;
        while(i <= j){
            while(i <= j && nums[i] % 2 == 1){
                i++;
            }
            while(i <= j && nums[j] % 2 == 0){
                j--;
            }
            if(i <= j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
    }
}
