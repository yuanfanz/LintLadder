package Tree.BST;

/**
 * Created by Frank on 16/7/11.
 */
class ResultType2 {
    boolean isBST;
    int minValue, maxValue;
    ResultType2(boolean isBST, int maxValue, int minValue){
        this.isBST = isBST;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
}
public class ValidBinarySearchTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        ResultType2 r = helper(root);
        return r.isBST;
    }
    private ResultType2 helper(TreeNode root){
        if(root == null){
            return new ResultType2(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        ResultType2 left = helper(root.left);
        ResultType2 right = helper(root.right);
        if(!left.isBST || !right.isBST){
            return new ResultType2(false, 0, 0);
        }
        if(root.left != null && left.maxValue >= root.val ||
                root.right != null && right.minValue <= root.val){
            return new ResultType2(false, 0, 0);
        }
        return new ResultType2(true, Math.max(root.val, right.maxValue),
                                     Math.min(root.val, left.minValue));
    }
}