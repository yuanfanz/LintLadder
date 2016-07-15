package DynamicProgramming.Basic;

/**
 * Created by Frank on 16/7/15.
 */
public class UniquePaths {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        //state
        int[][] sum = new int[m][n];
        //initialization
        sum[0][0] = 1;
        for(int i = 0; i < m; ++i){
            sum[i][0] = 1;
        }
        for(int i = 0; i < n; ++i){
            sum[0][i] = 1;
        }
        //function
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
            }
        }
        //answer
        return sum[m - 1][n - 1];
    }
}
