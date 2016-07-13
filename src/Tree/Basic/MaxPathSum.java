package Tree.Basic;

/**
 * Created by Frank on 16/7/12.
 */
public class MaxPathSum {
    /**
     * @param root the root of binary tree.
     * @return an integer
     */
    public int maxPathSum2(TreeNode root) {
        // Write your code here
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);

        return Math.max(0, Math.max(left, right)) + root.val;
    }
}
