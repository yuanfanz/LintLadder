package Search.DFS;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Frank on 16/8/27.
 */
public class Permutations2 {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.size() == 0){
            return result;
        }
        Collections.sort(nums);
        int[] visited = new int[nums.size()];
        ArrayList<Integer> permute = new ArrayList<Integer>();
        helper(result, permute, nums, visited);
        return result;
    }
    private void helper(ArrayList<ArrayList<Integer>> result,
                        ArrayList<Integer> permute,
                        ArrayList<Integer> nums, int[] visited){

        if(permute.size() == nums.size()){
            result.add( new ArrayList<Integer>(permute) );
        }
        for (int i = 0; i < nums.size(); ++i) {
            if (visited[i] == 1 || ( i != 0 && nums.get(i) == nums.get(i - 1) && visited[i - 1] == 0)) {
                continue;
            }
            visited[i] = 1;
            permute.add(nums.get(i));
            helper(result, permute, nums, visited);
            permute.remove(permute.size() - 1);
            visited[i] = 0;
        }
    }
}

