package Search.DFS;

import java.util.ArrayList;

/**
 * Created by Frank on 2016/10/30.
 */
public class NQueens {

    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (n <= 0) {
            return result;
        }
        int[] row = new int[n];
        findSolution(result, row, n, 0);
        return result;
    }
    private void findSolution(ArrayList<ArrayList<String>> result, int[] row, int n, int index) {
        if (index == n) {
            result.add(new ArrayList<String>(print(row)));
        }
        for (int i = 0; i < n; ++i) {
            if (isValid(row, index, i)) {
                row[index] = i;
                findSolution(result, row, n, index + 1);
                row[index] = 0;
            }
        }
    }
    private ArrayList<String> print(int[] row) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < row.length; ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < row.length; ++j) {
                if (row[j] == i) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            result.add(sb.toString());
        }
        return result;
    }
    private boolean isValid(int[] row, int rowNum, int column) {
        for (int i = 0; i < rowNum; ++i) {
            if (row[i] == column) {
                return false;
            }
            if (Math.abs(row[i] - column) == Math.abs(i - rowNum)) {
                return false;
            }
        }
        return true;
    }
}
