package Tree.Basic;

/**
 * Created by yuanf on 2016/7/8.
 */
public class MaxDepth {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root == null){
            return 0;
        }
        //divide
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        //conquer
        return Math.max(left, right) + 1;
    }
}