/**
 * Created by Frank on 16/6/29.
 */
public class SearchInsertPosition {
    /**
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            }
            if (A[mid] > target) {
                end = mid;
            }
        }
        if (A[end] < target) {
            return end + 1;
        } else if (A[start] >= target) {
            return start;
        } else return end;
    }
}
