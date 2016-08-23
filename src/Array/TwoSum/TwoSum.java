package Array.TwoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Frank on 16/8/16.
 */
public class TwoSum {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] result = new int[2];
        if(numbers == null || numbers.length == 0){
            return result;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; ++i){
            if(map.containsKey(numbers[i])){
                result[0] = map.get(numbers[i]) + 1;
                result[1] = i + 1;
                return result;
            }
            map.put(target - numbers[i], i);
        }
        return result;
    }
}