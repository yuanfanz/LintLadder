package DataStructure.SegmentTree;

/**
 * Created by Frank on 2016/11/12.
 */
public class RangeSumQuery2DMutable {
    public static class NumMatrix {

        private class SegmentTreeNode{
            int start;
            int end;
            int sum;
            SegmentTreeNode left;
            SegmentTreeNode right;
            public SegmentTreeNode(){}
            public SegmentTreeNode(int start, int end, int sum){
                this.start = start;
                this.end = end;
                this.sum = sum;
                this.left = null;
                this.right = null;
            }
        }

        int width;
        int height;
        SegmentTreeNode root;

        private int getIndex(int x, int y){
            return x * width + y;
        }

        public NumMatrix(int[][] matrix) {
            if(matrix == null || matrix.length == 0) return;

            height = matrix.length;
            width = matrix[0].length;

            root = buildTree(matrix, 0, width * height - 1);
        }

        private SegmentTreeNode buildTree(int[][] matrix, int start, int end){
            if(start == end) return new SegmentTreeNode(start, end, matrix[start / width][start % width]);

            int mid = start + (end - start) / 2;
            SegmentTreeNode left = buildTree(matrix, start, mid);
            SegmentTreeNode right = buildTree(matrix, mid + 1, end);
            SegmentTreeNode root = new SegmentTreeNode(start, end, left.sum + right.sum);
            root.left = left;
            root.right = right;

            return root;
        }

        public void update(int row, int col, int val) {
            int index = getIndex(row, col);
            update(root, index, val);
        }

        private void update(SegmentTreeNode root, int index, int val){
            if(root == null) return ;
            if(index < root.start) return;
            if(index > root.end) return;

            if(root.start == index && root.end == index){
                root.sum = val;
                return;
            }

            update(root.left, index, val);
            update(root.right, index, val);

            root.sum = root.left.sum + root.right.sum;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            if(col1 == 0 && col2 == width - 1){
                sum = querySum(root, getIndex(row1, col1), getIndex(row2, col2));
            } else {
                for(; row1 <= row2; row1++){
                    sum += querySum(root, getIndex(row1, col1), getIndex(row1, col2));
                }
            }


            return sum;
        }

        private int querySum(SegmentTreeNode root, int start, int end){
            if(root == null) return 0;
            if(start > root.end) return 0;
            if(end < root.start) return 0;

            start = Math.max(start, root.start);
            end = Math.min(end, root.end);

            if(start == root.start && end == root.end) return root.sum;

            int left = querySum(root.left, start, end);
            int right = querySum(root.right, start, end);

            return left + right;
        }
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix numMatrix = new NumMatrix(matrix);
        int a = numMatrix.sumRegion(2, 1, 4, 3);
        numMatrix.update(3, 2, 2);
        int b = numMatrix.sumRegion(2, 1, 4, 3);
        System.out.println(a);
        System.out.println(b);
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);