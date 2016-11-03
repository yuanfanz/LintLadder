package Backpack;

/**
 * Created by Frank on 2016/11/2.
 */
public class Backpack5 {
    /**
     * @param nums an integer array and all positive numbers
     * @param target an integer
     * @return an integer
     */
    public int backPackV(int[] nums, int target) {
        // Write your code here
        int[][] f = new int[nums.length + 1][target + 1];
        f[0][0] = 1;
        for (int i = 1; i <= target; ++i) {
            f[0][i] = 0;
        }
        for (int i = 1; i <= nums.length; ++i) {
            for (int j = 0; j <= target; ++j) {
                f[i][j] = f[i - 1][j];
                if (j >= nums[i - 1]) {
                    f[i][j] = f[i - 1][j] + f[i - 1][j - nums[i - 1]];
                }
            }
        }
        return f[nums.length][target];
    }
}