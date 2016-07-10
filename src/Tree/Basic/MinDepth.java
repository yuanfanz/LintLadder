package Tree.Basic;

/**
 * Created by yuanf on 2016/7/9.
 */
public class MinDepth {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if(root == null){
            return 0;
        }
        return min(root);
    }
    private int min(TreeNode root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return Math.min(min(root.left), min(root.right)) + 1;
    }
}