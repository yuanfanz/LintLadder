package Array.PartitionArray;

/**
 * Created by Frank on 16/8/17.
 */
public class InterleavingPositiveAndNegative {
    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return;
        }
        int[] result = new int[nums.length];
        int[] po = new int[nums.length];
        int[] ne = new int[nums.length];
        int totp = 0;
        int totn = 0;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] > 0){
                po[totp++] = nums[i];
            } else {
                ne[totn++] = nums[i];
            }
        }
        if(totp > totn){
            result = merge(po, ne, nums.length);
        } else {
            result = merge(ne, po, nums.length);
        }
        for(int i = 0; i < result.length; ++i){
            nums[i] = result[i];
        }
    }
    private int[] merge(int[] a, int[] b, int len){
        int[] result = new int[len];
        for(int i = 0; 2 * i + 1 < len; ++i){
            result[2 * i] = a[i];
            result[2 * i + 1] = b[i];
        }
        if(len % 2 == 1){
            result[len - 1] = a[len / 2];
        }
        return result;
    }
}