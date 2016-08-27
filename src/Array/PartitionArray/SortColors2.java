package Array.PartitionArray;

/**
 * Created by Frank on 16/8/17.
 */
public class SortColors2 {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if(colors == null || colors.length == 0){
            return;
        }
        int count = 0;
        int start = 0, end = colors.length - 1;
        while(count < k){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int i = start; i <= end; ++i){
                max = Math.max(max, colors[i]);
                min = Math.min(min, colors[i]);
            }
            int cur = start, left = start, right = end;
            while(cur <= right){
                if(colors[cur] == min){
                    swap(cur, left, colors);
                    cur++;
                    left++;
                } else if (colors[cur] == max){
                    swap(cur, right, colors);
                    right--;
                } else {
                    cur++;
                }
            }
            count += 2;
            start = left;
            end = right;
        }
    }
    void swap(int left, int right, int[] colors) {
        int tmp = colors[left];
        colors[left] = colors[right];
        colors[right] = tmp;
    }
}