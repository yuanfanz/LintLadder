package Backpack;

/**
 * Created by Frank on 2016/11/2.
 */
public class Backpack2 {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] a, int v[]) {
        // write your code here
        int[][] f = new int[a.length + 1][m + 1];
        for (int i = 0; i <= m; ++i) {
            f[0][i] = 0;
        }
        for (int i = 1; i <= a.length; ++i) {
            for (int j = 1; j <= m; ++j) {
                f[i][j] = f[i - 1][j];
                if (j >= a[i - 1]) {
                    f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - a[i - 1]] + v[i - 1]);
                }
            }
        }
        return f[a.length][m];
    }
}
