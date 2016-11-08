package Backpack;

import java.util.*;
/**
 * Created by Frank on 2016/11/6.
 */
public class Backpack6DFS {
    /**
     * @param nums an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */

    /**
     * The DFS recursion will cause stack overflow when
     * the target is big (e.g. 32)
     */
    public int backPackVI(int[] candidates, int target) {
        // Write your code here
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return 0;
        }
        Arrays.sort(candidates);
        ArrayList<Integer> list = new ArrayList<>();
        helper(result, list, candidates, target, 0);
        return result.size();
    }
    private void helper(ArrayList<List<Integer>> result,
                        ArrayList<Integer> list,
                        int[] candidates, int target, int index) {

        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        int prev = -1;
        for (int i = 0; i < candidates.length; ++i) {
            if (candidates[i] > target) {
                break;
            }
            if (prev != -1 && prev == candidates[i]) {
                continue;
            }
            list.add(candidates[i]);
            helper(result, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
            prev = candidates[i];
        }
    }
}