package Array.TwoSum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Frank on 16/8/16.
 */
public class ThreeSum {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(numbers == null || numbers.length < 3){
            return result;
        }
        Arrays.sort(numbers);
        for(int k = 0; k < numbers.length - 2; ++k){
            if (k != 0 && numbers[k] == numbers[k - 1]) {
                continue; // to skip duplicate numbers; e.g [0,0,0,0]
            }
            int target = 0 - numbers[k];
            int i = k + 1, j = numbers.length - 1;
            while(i < j){
                if(numbers[i] + numbers[j] == target){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(numbers[k]);
                    list.add(numbers[i]);
                    list.add(numbers[j]);
                    result.add(list);
                    i++;
                    j--;
                    while (i < j && numbers[i] == numbers[i - 1]) { // to skip duplicates
                        i++;
                    }
                    while (i < j && numbers[j] == numbers[j + 1]) { // to skip duplicates
                        j--;
                    }
                } else if(numbers[i] + numbers[j] > target){
                    j--;
                } else {
                    i++;
                }
            }
        }
        return result;
    }
}