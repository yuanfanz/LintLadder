package Array.Basic;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Frank on 16/8/18.
 */


/**
 * 这道题要会用三种解法
 */


public class IntersectionOfTwoArrays {
    /**
     * 本题的第一种解法 使用hashset 循环两次 O(N)
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        int[] re = new int[0];
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
            return re;
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums1.length; ++i){
            set.add(nums1[i]);
        }
        Set<Integer> res = new HashSet<Integer>();
        for(int i = 0; i < nums2.length; ++i){
            if(set.contains(nums2[i])){
                res.add(nums2[i]);
            }
        }
        int[] result = new int[res.size()];
        int index = 0;
        for (Integer num : res) {
            result[index++] = num;
        }
        return result;
    }
}