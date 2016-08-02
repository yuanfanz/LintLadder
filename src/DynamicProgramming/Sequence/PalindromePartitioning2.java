package DynamicProgramming.Sequence;

/**
 * Created by Frank on 16/8/1.
 */
public class PalindromePartitioning2 {
    /**
     * @param s a string
     * @return an integer
     */
    private boolean[][] isPalindrome(String s){
        int n = s.length();
        boolean[][] f = new boolean[n][n];

        for(int i = 0; i < n; ++i){
            f[i][i] = true;
        }
        for(int i = 0; i < n - 1; ++i){
            f[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        // 倒过来 先算大的方法
        // for(int i = n - 1; i >= 0; --i){
        //     for(int j = i + 2; j < n; ++j){
        //         f[i][j] = f[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
        //     }
        // }

        //更本质的方法 先for长度再for起点
        for(int len = 2; len < n; ++len){
            for(int start = 0; start + len < n; ++ start){
                f[start][start + len] = f[start + 1][start + len - 1] && (s.charAt(start) == s.charAt(start + len));
            }
        }

        return f;
    }
    public int minCut(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        boolean[][] isPali = isPalindrome(s);

        int[] f = new int[n + 1];
        f[0] = 0;
        for(int i = 1; i <= n; ++i){
            f[i] = Integer.MAX_VALUE;
            for(int j = 0; j < i; ++j){
                if(isPali[j][i - 1]){
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[n] - 1;
    }
}