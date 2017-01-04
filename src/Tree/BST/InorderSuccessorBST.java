package Tree.BST;

/**
 * Created by yuanfanz on 17/1/3.
 */
public class InorderSuccessorBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null) return null;
        TreeNode res = null;
        while (root != null) {
            if (root.val > p.val) {
                res = root;
                root = root.left;
            } else root = root.right;
        }
        return res;
    }
}