package Bisection;

/**
 * Created by yuanf on 2016/7/4.
 */
public class TotalOccurrence {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public static int totalOccurrence(int[] A, int target) {
        // Write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        int first = 0;
        int last = 0;
        int count = 0;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (A[mid] >= target){
                end = mid;
            } else {
                start = mid;
            }
        }
        if(A[start] == target){
            first = start;
        } else if (A[end] == target){
            first = end;
        } else {
            return 0;
        }
        start = 0;
        end = A.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (A[mid] <= target){
                start = mid;
            } else {
                end = mid;
            }
        }
        if(A[end] == target){
            last = end;
        } else if (A[start] == target){
            last = start;
        } else {
            return 0;
        }
        System.out.println(last);
        System.out.println(first);
        count = last - first + 1;
        return count;
    }

    public static void main(String[] args){
        int A[] = {2,2,3,4,6};
        int target = 4;
        System.out.println(totalOccurrence(A, target));
    }
}
