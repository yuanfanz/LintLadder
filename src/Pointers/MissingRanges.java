package Pointers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frank on 2016/11/13.
 */
public class MissingRanges {
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (lower > upper) {
            return result;
        } else if (nums == null || nums.length == 0) {
            result.add(getString(lower, upper));
            return result;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (lower == nums[i]) {
                lower++;
                continue;
            } else if (lower < nums[i]) {
                result.add(getString(lower, nums[i] - 1));
                if (nums[i] == upper) {
                    return result;
                }
                lower = nums[i] + 1;
            }

        }
        if (lower <= upper) {//[-1] -1, 0
            result.add(getString(lower, upper));
        }
        return result;
    }

    private static String getString(int start, int end) {
        StringBuilder sb = new StringBuilder();
        if (start == end) {
            sb.append(start);
        } else {
            sb.append(start + "->" + end);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        int[] test = new int[]{Integer.MAX_VALUE};
        int lower = 0;
        int upper = Integer.MAX_VALUE;
        List<String> result = findMissingRanges(test, lower, upper);
        result.forEach(System.out::println);
    }
}