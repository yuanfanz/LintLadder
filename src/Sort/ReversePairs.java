package Sort;

/**
 * Created by Frank on 16/8/7.
 */
public class ReversePairs {
    /**
     * @param A an array
     * @return total of reverse pairs
     */
    public long reversePairs(int[] a) {
        // Write your code here
        if(a == null || a.length == 0){
            return 0;
        }
        return mergeSort(a, 0, a.length - 1);
    }
    private int mergeSort(int[] a, int start, int end){
        if(start >= end){
            return 0;
        }
        int sum = 0;
        int mid = (start + end) / 2;
        sum += mergeSort(a, start, mid);
        sum += mergeSort(a, mid + 1, end);
        sum += merge(a, start, mid, end);
        return sum;
    }
    private int merge(int[] a, int start, int mid, int end){
        int[] tmp = new int[a.length];
        int left = start;
        int right = mid + 1;
        int index = start;
        int sum = 0;
        while(left <= mid && right <= end){
            if(a[left] <= a[right]){
                tmp[index++] = a[left++];
            } else {
                tmp[index++] = a[right++];
                sum += mid - left + 1;
            }
        }
        while(left <= mid){
            tmp[index++] = a[left++];
        }
        while(right <= end){
            tmp[index++] = a[right++];
        }
        for (int i = start; i <= end; i++) {
            a[i] = tmp[i];
        }

        return sum;
    }
}