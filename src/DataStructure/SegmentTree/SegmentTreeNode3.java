package DataStructure.SegmentTree;

/**
 * Created by Frank on 2016/11/8.
 */
public class SegmentTreeNode3 {
    public int start, end, count;
    public SegmentTreeNode3 left, right;

    public SegmentTreeNode3(int start, int end, int count) {
        this.start = start;
        this.end = end;
        this.count = count;
        this.left = this.right = null;
    }
}

