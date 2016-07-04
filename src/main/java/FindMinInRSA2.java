/**
 * Created by Frank on 16/6/30.
 */
public class FindMinInRSA2 {

    /**
     * 在有重复元素的RSA中找最小值
     *
     * 这道题目在面试中不会让写完整的程序
     * 只需要知道最坏情况下 [1,1,1....,1] 里有一个0
     * 这种情况使得时间复杂度必须是 O(n)
     * 因此写一个for循环就好了。
     * 如果你觉得，不是每个情况都是最坏情况，你想用二分法解决不是最坏情况的情况，那就写一个二分吧。
     * 反正面试考的不是在这个题上会不会用二分法。这个题的考点是想不想得到最坏情况。
     */

    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if(num == null || num.length == 0){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < num.length; ++i){
            if(num[i] < min){
                min = num[i];
            }
        }
        return min;
    }

    /**
     * version 2: use *fake* binary-search
     */
    public class findMinBi {
        /**
         * @param nums: a rotated sorted array
         * @return: the minimum number in the array
         */
        public int findMin(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int start = 0, end = nums.length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == nums[end]) {
                    // if mid equals to end, that means it's fine to remove end
                    // the smallest element won't be removed
                    end--;
                } else if (nums[mid] < nums[end]) {
                    end = mid;
                    // of course you can merge == & <
                } else {
                    start = mid;
                    // or start = mid + 1
                }
            }

            if (nums[start] <= nums[end]) {
                return nums[start];
            }
            return nums[end];
        }
    }
}
