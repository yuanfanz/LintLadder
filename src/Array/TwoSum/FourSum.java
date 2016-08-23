package Array.TwoSum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Frank on 16/8/16.
 */
public class FourSum {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        /* your code */
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(numbers == null || numbers.length < 4){
            return result;
        }
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length - 3; ++i){
            if(i != 0 && numbers[i] == numbers[i - 1]){
                continue;
            }
            for(int j = i + 1; j < numbers.length - 2; ++j){
                if(j != i + 1 && numbers[j] == numbers[j - 1]){
                    continue;
                }
                int left = j + 1;
                int right = numbers.length - 1;
                while(left < right){
                    int sum = numbers[i] + numbers[j] + numbers[left] + numbers[right];
                    if(sum == target){
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[left]);
                        list.add(numbers[right]);
                        result.add(list);
                        left++;
                        right--;
                        while(left < right && numbers[left] == numbers[left - 1]){
                            left++;
                        }
                        while(left < right && numbers[right] == numbers[right + 1]){
                            right--;
                        }
                    } else if (sum < target){
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}