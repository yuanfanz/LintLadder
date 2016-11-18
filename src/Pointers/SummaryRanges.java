package Pointers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frank on 2016/11/13.
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int left = nums[0];
        int right = left;
        for (int i = 1; i < nums.length; ++i) {
            if (right == nums[i] - 1) {
                right++;
                continue;
            } else {
                result.add(getString(left, right));
            }
            left = nums[i];
            right = left;
        }
        result.add(getString(left, right));
        return result;
    }
    private String getString(int start, int end) {
        StringBuilder sb = new StringBuilder();
        if (start == end) {
            sb.append(start);
        } else {
            sb.append(start + "->" + end);
        }
        return sb.toString();
    }
}