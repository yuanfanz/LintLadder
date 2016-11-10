package DataStructure.SegmentTree;

/**
 * Created by Frank on 2016/11/8.
 */
public class SegmentTreeNode2 {
    public int start, end, max;
    public SegmentTreeNode2 left, right;

    public SegmentTreeNode2(int start, int end, int max) {
        this.start = start;
        this.end = end;
        this.max = max;
        this.left = this.right = null;
    }
}

