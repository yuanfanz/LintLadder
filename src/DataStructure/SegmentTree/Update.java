package DataStructure.SegmentTree;

/**
 * Created by Frank on 2016/11/12.
 */
public class Update {
    /**
     *@param root, index, value: The root of segment tree and
     *@ change the node's value with [index, index] to the new given value
     *@return: void
     */
    public void modify(SegmentTreeNode2 root, int index, int value) {
        // write your code here
        if (root == null || index < root.start || index > root.end) {
            return;
        }
        if (index == root.start && index == root.end) {
            root.max = value;
            return;
        }
        modify(root.left, index, value);
        modify(root.right, index, value);

        root.max = Math.max(root.left.max, root.right.max);
    }
}