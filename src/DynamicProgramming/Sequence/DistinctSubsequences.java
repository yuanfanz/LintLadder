package DynamicProgramming.Sequence;

/**
 * Created by Frank on 16/8/2.
 */
public class DistinctSubsequences {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        if (S == null || T == null) {
            return 0;
        }
        int m = S.length();
        int n = T.length();

        int[][] f = new int[m + 1][n + 1];
        for(int i = 0; i <= m; ++i){
            f[i][0] = 1;
        }

        for(int i = 1; i <= m; ++i){
            for(int j = 1; j <= n; ++j){
                f[i][j] = f[i - 1][j];
                if(S.charAt(i - 1) == T.charAt(j - 1)){
                    f[i][j] += f[i - 1][j - 1];
                }
            }
        }
        return f[m][n];
    }
}
