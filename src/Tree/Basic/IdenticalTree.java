package Tree.Basic;

/**
 * Created by yuanf on 2016/7/9.
 */
public class IdenticalTree {
    /**
     * @param a, b, the root of binary trees.
     * @return true if they are identical, or false.
     */
    public boolean isIdentical(TreeNode a, TreeNode b) {
        // Write your code here
        if (a == null && b == null){
            return true;
        }
        if (a == null || b == null){
            return false;
        }
        if (a.val != b.val){
            return false;
        }
        return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }
}