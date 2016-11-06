package Search.DFS;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Frank on 16/8/26.
 */
public class Subset {
    /**
     * 递归的方法 DFS
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        ArrayList<Integer> subset = new ArrayList<Integer>();

        helper(result, subset, nums, 0);
        return result;
    }
    private void helper(ArrayList<ArrayList<Integer>> result,
                        ArrayList<Integer> subset,
                        int[] nums, int start){

        result.add(new ArrayList<Integer>(subset));
        for(int i = start; i < nums.length; ++i){
            subset.add(nums[i]);
            helper(result, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    /**
     * 非递归的方法, 用的是位运算的思想
     * 二进制解决
     *  1 << n is 2^n
     // each subset equals to an binary integer between 0 .. 2^n - 1
     // 0 -> 000 -> []
     // 1 -> 001 -> [1]
     // 2 -> 010 -> [2]
     // ..
     // 7 -> 111 -> [1,2,3]
     */

    public ArrayList<ArrayList<Integer>> subsetsNonRecursion(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.length == 0){
            return result;
        }
        int n = nums.length;
        Arrays.sort(nums);

        for(int i = 0; i < (1 << n); ++i){
            ArrayList<Integer> subset = new ArrayList<Integer>();
            for(int j = 0; j < n; ++j){
                if((i & (1 << j)) != 0){
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }
}