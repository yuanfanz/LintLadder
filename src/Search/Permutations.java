package Search;

import java.util.ArrayList;

/**
 * Created by Frank on 16/8/26.
 */
public class Permutations {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.size() == 0){
            return result;
        }
        ArrayList<Integer> permute = new ArrayList<Integer>();
        helper(result, permute, nums);
        return result;
    }
    private void helper(ArrayList<ArrayList<Integer>> result,
                        ArrayList<Integer> permute,
                        ArrayList<Integer> nums){

        if(permute.size() == nums.size()){
            result.add(new ArrayList<Integer>(permute));
            return;
        }

        for(int i = 0; i < nums.size(); ++i){
            if(permute.contains(nums.get(i))){
                continue;
            }
            permute.add(nums.get(i));
            helper(result, permute, nums);
            permute.remove(permute.size() - 1);
        }
    }
}

