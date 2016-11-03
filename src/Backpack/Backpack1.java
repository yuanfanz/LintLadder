package Backpack;

/**
 * Created by Frank on 2016/11/1.
 */
public class Backpack1 {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] a) {
        // write your code here
        int[][] f = new int[a.length + 1][m + 1];
        //initialization
        for (int i = 0; i <= m; ++i) {
            f[0][i] = 0;
        }
        for (int i = 1; i <= a.length; ++i) {
            for (int j = 1; j <= m; ++j) {
                f[i][j] = f[i - 1][j];
                if (j >= a[i - 1]) {
                    f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - a[i - 1]] + a[i - 1]);
                }
            }
        }
        return f[a.length][m];
    }
}