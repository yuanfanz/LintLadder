/**
 * Created by Frank on 16/6/30.
 */
public class FindMinInRSA {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if (num == null || num.length == 0){
            return -1;
        }
        int start = 0;
        int end = num.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(num[mid] <= num[num.length - 1]){
                end = mid;
            }
            if(num[mid] > num[num.length - 1]){
                start = mid;
            }
        }
        if(num[start] <= num[num.length - 1]){
            return num[start];
        } else if (num[end] <= num[num.length - 1]){
            return num[end];
        } else return -1;
    }
}
