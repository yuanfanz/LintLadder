package Array.PartitionArray;

/**
 * Created by Frank on 16/8/17.
 */
public class WiggleSort {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        // Write your code here
        if(nums == null || nums.length == 0){
            return;
        }
        for(int i = 1; i < nums.length; ++i){
            if((i % 2 == 1 && nums[i] < nums[i - 1]) || (i % 2 == 0 && nums[i] > nums[i - 1])){
                int tmp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = tmp;
            }
        }
    }
}