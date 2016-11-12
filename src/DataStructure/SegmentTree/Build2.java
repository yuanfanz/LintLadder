package DataStructure.SegmentTree;

/**
 * Created by Frank on 2016/11/8.
 */
public class Build2 {
    public SegmentTreeNode2 build(int[] a) {
        // write your code here
        int start = 0;
        int end = a.length - 1;
        return helper(start, end, a);
    }
    private SegmentTreeNode2 helper(int start, int end, int[] a) {
        if (start > end) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; ++i) {
            max = Math.max(max, a[i]);
        }
        SegmentTreeNode2 root = new SegmentTreeNode2(start, end, max);
        if (start == end) {
            return root;
        }
        int mid = start + (end - start) / 2;
        root.left = helper(start, mid, a);
        root.right = helper(mid + 1, end, a);
        return root;
    }

    /**
     * Another method to get this segment tree built
     * with Divide & Conquer
     */
    private SegmentTreeNode2 build2(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        return helper(a, 0, a.length - 1);
        }
    private SegmentTreeNode2 helper(int[] a, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new SegmentTreeNode2(start, end, a[start]);
        }
        int mid = start + (end - start) / 2;
        SegmentTreeNode2 left = helper(a, start, mid);
        SegmentTreeNode2 right = helper(a, mid + 1, end);

        SegmentTreeNode2 root = new SegmentTreeNode2(start, end, Math.max(left.max, right.max));
        root.left = left;
        root.right = right;
        return root;
    }
}