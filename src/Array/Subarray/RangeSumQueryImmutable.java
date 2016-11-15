package Array.Subarray;

/**
 * Created by Frank on 2016/11/12.
 */
public class RangeSumQueryImmutable {
    public class NumArray {
        int[] prefix;

        public NumArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }
            prefix = new int[nums.length + 1];
            prefix[0] = 0;
            prefix[1] = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return prefix[j + 1] - prefix[i];
        }
    }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);