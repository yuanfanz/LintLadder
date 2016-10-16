package Search;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Frank on 16/8/26.
 */
public class Subset2 {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(S == null || S.size() == 0){
            return result;
        }
        Collections.sort(S);
        ArrayList<Integer> subset = new ArrayList<Integer>();
        helper(result, subset, S, 0);
        return result;
    }
    private void helper(ArrayList<ArrayList<Integer>> result,
                        ArrayList<Integer> subset,
                        ArrayList<Integer> S, int start){
        result.add(new ArrayList<Integer>(subset));
        for(int i = start; i < S.size(); ++i){
            if(i != start && S.get(i) == S.get(i - 1)){
                continue;
            }
            subset.add(S.get(i));
            helper(result, subset, S, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}

