package Tree.Basic;

/**
 * Created by yuanf on 2016/7/9.
 */
public class SymmetricTree {
    /**
     * @param root, the root of binary tree.
     * @return true if it is a mirror of itself, or false.
     */
    public boolean isSymmetric(TreeNode root) {
        // Write your code here
        if (root == null){
            return true;
        }
        return check(root.left, root.right);
    }
    //cause we have to determine the symmetric nature of this tree
    //we need two parameters thus we need a new method for recursion
    private boolean check(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        return check(root1.left, root2.right) && check(root1.right, root2.left);
    }
}
