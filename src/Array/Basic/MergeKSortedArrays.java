package Array.Basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frank on 16/8/19.
 */
public class MergeKSortedArrays {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        if(arrays.length == 0 || arrays[0].length == 0 || arrays == null){
            return result;
        }
        int[] re = helper(arrays, 0, arrays.length - 1);
        for(int i = 0; i < re.length; ++i){
            result.add(re[i]);
        }
        return result;
    }
    private int[] helper(int[][] arrays, int start, int end){
        if(start >= end){
            return arrays[start];
        }
        int mid = start + (end - start) / 2;
        int[] left = helper(arrays, start, mid);
        int[] right = helper(arrays, mid + 1, end);
        return merge(left, right);
    }
    private int[] merge(int[] a, int[] b){
        if(a == null && b == null || a.length == 0 && b.length == 0){
            return null;
        }
        int[] tmp = new int[a.length + b.length];
        int i = 0, j = 0;
        while(i < a.length && j < b.length){
            if(a[i] <= b[j]){
                tmp[i + j] = a[i++];
            } else {
                tmp[i + j] = b[j++];
            }
        }
        while(i < a.length){
            tmp[i + j] = a[i++];
        }
        while(j < b.length){
            tmp[i + j] = b[j++];
        }
        return tmp;
    }
}