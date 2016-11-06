package Search.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Frank on 2016/11/2.
 */
public class CombinationSum {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        helper(result, list, candidates, target, 0);
        return result;
    }
    private void helper(ArrayList<List<Integer>> result,
                        ArrayList<Integer> list, int[] candidates,
                        int target, int index) {

        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
        }
        int prev = -1;
        for (int i = index; i < candidates.length; ++i) {
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
