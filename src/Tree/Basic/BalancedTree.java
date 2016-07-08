package Tree.Basic;

/**
 * Created by yuanf on 2016/7/8.
 */
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
class ResultType {
    public boolean isBalanced;
    public int maxDepth;
    public ResultType(boolean isBalanced, int maxDepth) {
        this.isBalanced = isBalanced;
        this.maxDepth = maxDepth;
    }
}
public class BalancedTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        ResultType result = helper(root);
        return result.isBalanced;
    }
    private ResultType helper(TreeNode root){
        if (root == null){
            return new ResultType(true, 0);
        }
        //divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        //conquer
        if(left.isBalanced && right.isBalanced && Math.abs(left.maxDepth - right.maxDepth) <= 1){
            return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
        } else return new ResultType(false, -1);
    }
}