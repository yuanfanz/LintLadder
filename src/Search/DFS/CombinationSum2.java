package Search.DFS;

import java.util.*;
/**
 * Created by Frank on 2016/11/2.
 */
public class CombinationSum2 {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0) {
            return result;
        }
        int[] visited = new int[num.length];
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(num);
        helper(result, list, num, visited, target, 0);
        return result;
    }
    private void helper(ArrayList<List<Integer>> result,
                        ArrayList<Integer> list, int[] num,
                        int[] visited, int target, int index) {

        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
        }
        for (int i = index; i < num.length; ++i) {
            if (num[i] > target) {
                break;
            }
            if (visited[i] == 1 || i != 0 && num[i] == num[i - 1] && visited[i - 1] == 0) {
                continue;
            }
            visited[i] = 1;
            list.add(num[i]);
            helper(result, list, num, visited, target - num[i], i + 1);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }
}