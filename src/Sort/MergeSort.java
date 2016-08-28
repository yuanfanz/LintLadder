package Sort;

/**
 * Created by Frank on 16/8/18.
 */
public class MergeSort {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] a) {
        // Write your code here
        if(a == null || a.length == 0){
            return;
        }
        int[] tmp = new int[a.length];
        mergeSort(a, 0, a.length - 1, tmp);
    }
    private void mergeSort(int[] a, int start, int end, int[] tmp){
        if(start >= end){
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(a, start, mid, tmp);
        mergeSort(a, mid + 1, end, tmp);
        merge(a, start, mid, end, tmp);
    }
    private void merge(int[] a, int start, int mid, int end, int[] tmp){
        int left = start;
        int right = mid + 1;
        int index = start;

        while(left <= mid && right <= end){
            if(a[left] < a[right]){
                tmp[index++] = a[left++];
            } else {
                tmp[index++] = a[right++];
            }
        }
        while(left <= mid){
            tmp[index++] = a[left++];
        }
        while(right <= end){
            tmp[index++] = a[right++];
        }

        for(int i = start; i <= end; ++i){
            a[i] = tmp[i];
        }
    }
}