package DataStructure.SegmentTree;

/**
 * Created by Frank on 2016/11/12.
 */

/**
 * Find the number of elements in a certain interval
 */
public class Query2 {
    /**
     *@param root, start, end: The root of segment tree and
     *                         an segment / interval
     *@return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode3 root, int start, int end) {
        // write your code here
        if (root == null || start > root.end || end < root.start) {
            return 0;
        }
        start = Math.max(start, root.start);
        end = Math.min(end, root.end);

        if (start == root.start && end == root.end) {
            return root.count;
        }
        int left = query(root.left, start, end);
        int right = query(root.right, start, end);
        return left + right;
    }
}