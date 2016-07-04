public class Search2DMatrix2 {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int x = m - 1;
        int y = 0;
        int count = 0;
        while(x >= 0 && y <= n - 1){


            if(matrix[x][y] < target){
                y++;
            } else if (matrix[x][y] > target){
                x--;
            } else {
                count++;
                x--;
                y++;
            }
        }
        return count;
    }
}