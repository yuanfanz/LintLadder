package DataStructure.SegmentTree;

/**
 * Created by Frank on 2016/11/11.
 */
public class Query1 {
    /**
     *@param root, start, end: The root of segment tree and
     *                         an segment / interval
     *@return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode2 root, int start, int end) {
        // write your code here
        if (start > root.end || end < root.start) {
            return Integer.MIN_VALUE;
        }

        start = Math.max(start, root.start);
        end = Math.min(end, root.end);

        if (start == root.start && end == root.end) {
            return root.max;
        }

        int left = query(root.left, start, end);
        int right = query(root.right, start, end);

        return Math.max(left, right);
    }
}