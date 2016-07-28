package Basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Frank on 16/7/25.
 */
public class RemoveDuplicate {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        // Write your code here
        /**
         * Time: O(n)
         * Space: O(n)
         */
        HashMap<Integer, Boolean> result = new HashMap<Integer, Boolean>();
        for(int i = 0; i < nums.length; ++i){
            result.put(nums[i], true);
        }
        int tar = 0;
        for(Map.Entry<Integer, Boolean> entry : result.entrySet()){
            nums[tar++] = entry.getKey();
        }
        return tar;
    }

    public int deduplication2(int[] nums) {
        /**
         * Time: O(nlogn)
         * Space: O(1)
         */
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int len = 0;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] != nums[len]){
                nums[++len] = nums[i];
            }
        }
        return len + 1;
    }
}
