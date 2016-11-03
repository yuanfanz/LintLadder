package Backpack;

/**
 * Created by Frank on 2016/11/2.
 */
public class Backpack3 {
    /**
     * @param A an integer array
     * @param V an integer array
     * @param m an integer
     * @return an array
     */
    public int backPackIII(int[] a, int[] v, int m) {
        // Write your code here
        int[][] f = new int[a.length + 1][m + 1];
        for (int i = 0; i <= m; ++i) {
            f[0][i] = 0;
        }
        for (int i = 1; i <= a.length; ++i) {
            for (int j = 1; j <= m; ++j) {
                f[i][j] = f[i - 1][j];
                if (j >= a[i - 1]) {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - a[i - 1]] + v[i - 1]);
                }
            }
        }
        return f[a.length][m];
    }
}