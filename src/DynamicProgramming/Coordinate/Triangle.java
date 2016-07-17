package DynamicProgramming.Coordinate;

/**
 * Created by yuanf on 2016/7/16.
 */
public class Triangle {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if(triangle == null || triangle.length == 0){
            return -1;
        }
        if(triangle[0] == null || triangle[0].length == 0){
            return -1;
        }
        int n = triangle.length;
        int[][] sum = new int[n][n];
        sum[0][0] = triangle[0][0];

        for(int i = 1; i < n; ++i){
            sum[i][0] = sum[i - 1][0] + triangle[i][0];
            sum[i][i] = sum[i - 1][i - 1] + triangle[i][i];
        }
        for(int i = 1; i < n; ++i){
            for(int j = 1; j < i; ++j){
                sum[i][j] = Math.min(sum[i - 1][j], sum[i - 1][j - 1]) + triangle[i][j];
            }
        }
        int best = sum[n - 1][0];
        for(int i = 0; i < n; ++i){
            best = Math.min(best, sum[n - 1][i]);
        }
        return best;
    }
}

